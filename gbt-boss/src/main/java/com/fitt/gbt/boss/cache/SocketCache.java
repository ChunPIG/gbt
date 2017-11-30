package com.fitt.gbt.boss.cache;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>@description: TCP Socket连接全局缓存</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-11-02</p>
 * <p>@version: 1.0</p>
 */
public class SocketCache {
	private static final Logger logger = LoggerFactory.getLogger(SocketCache.class);

	private static ConcurrentHashMap<Integer, ChannelHandlerContext> socketCacheMap = new ConcurrentHashMap<>();
	private static ConcurrentHashMap<Integer, HttpRequest> requestCacheMap = new ConcurrentHashMap<>();

	/************************************ Socket *************************************/
	public static ChannelHandlerContext get(Integer key) {
		return socketCacheMap.get(key);
	}

	public static void set(Integer key, ChannelHandlerContext value) {
		socketCacheMap.put(key, value);
	}

	public static boolean remove(Integer key) {
		boolean ret = false;
		if (socketCacheMap.keySet().contains(key)) {
			socketCacheMap.remove(key);
			ret = true;
		}

		return ret;
	}

	public static void remove(ChannelHandlerContext context) {
		for (Iterator<Map.Entry<Integer, ChannelHandlerContext>> iterator = socketCacheMap.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<Integer, ChannelHandlerContext> entry = iterator.next();
			Integer key = entry.getKey();
			ChannelHandlerContext ctx = entry.getValue();
			if (context.hashCode() == ctx.hashCode()) {
				logger.warn("......remove() remove Channel key={}, context hashCode={}", key, ctx.hashCode());
				iterator.remove();
				removeRequest(key);
				break;
			}
		}
	}

	public static boolean contains(ChannelHandlerContext context) {
		boolean result = false;
		for (Iterator<Map.Entry<Integer, ChannelHandlerContext>> iterator = socketCacheMap.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<Integer, ChannelHandlerContext> entry = iterator.next();
			Integer key = entry.getKey();
			ChannelHandlerContext ctx = entry.getValue();
			if (context.hashCode() == ctx.hashCode()) {
				logger.warn("......remove() remove Channel key={}, context hashCode={}", key, ctx.hashCode());
				result = true;
				break;
			}
		}
		return result;
	}

	/************************************ HttpRequest *************************************/
	public static HttpRequest getRequest(Integer key) {
		return requestCacheMap.get(key);
	}

	public static void setRequest(Integer key, HttpRequest value) {
		requestCacheMap.put(key, value);
	}

	public static boolean removeRequest(Integer key) {
		boolean ret = false;
		if (requestCacheMap.keySet().contains(key)) {
			requestCacheMap.remove(key);
			ret = true;
		}

		return ret;
	}

	public static void removeRequest(HttpRequest request) {
		for (Iterator<Map.Entry<Integer, HttpRequest>> iterator = requestCacheMap.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<Integer, HttpRequest> entry = iterator.next();
			Integer key = entry.getKey();
			HttpRequest req = entry.getValue();
			if (request.hashCode() == req.hashCode()) {
				logger.warn("......remove() remove Channel key={}, context hashCode={}", key, req.hashCode());
				iterator.remove();
				break;
			}
		}
	}

	public static boolean containRequest(HttpRequest request) {
		boolean result = false;
		for (Iterator<Map.Entry<Integer, HttpRequest>> iterator = requestCacheMap.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<Integer, HttpRequest> entry = iterator.next();
			Integer key = entry.getKey();
			HttpRequest req = entry.getValue();
			if (request.hashCode() == req.hashCode()) {
				logger.warn("......remove() remove Channel key={}, context hashCode={}", key, req.hashCode());
				result = true;
				break;
			}
		}
		return result;
	}
	/*******************************************************************************/

	public static ConcurrentHashMap<Integer, ChannelHandlerContext> getSocketCacheMap() {
		return socketCacheMap;
	}

	private static AtomicInteger atomicInteger = new AtomicInteger();
	public static int getUniqueID() {
		return atomicInteger.getAndIncrement();
	}
}
