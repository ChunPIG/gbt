package com.fitt.gbt.boss.time;

import com.fitt.gbt.boss.cache.SocketCache;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * <p>@description: com.fitt.gbt.boss.time</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-11-02</p>
 * <p>@version: 1.0</p>
 */
public class SendMessageTask implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(SendMessageTask.class);

	@Override
	public void run() {
		ConcurrentHashMap map = SocketCache.getSocketCacheMap();
		if (!map.isEmpty()) {
			logger.info("......run() current client connect size={}", map.size());
			for (Iterator<Map.Entry> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
				Map.Entry entry = iterator.next();
				Integer id = (Integer) entry.getKey();
				ChannelHandlerContext context = (ChannelHandlerContext) entry.getValue();
				HttpRequest request = SocketCache.getRequest(id);

//				FullHttpResponse response = getResponse(request);
//				context.writeAndFlush(response);

				StringBuilder sb = new StringBuilder(128);
				sb.append(id).append("-->").append(System.currentTimeMillis());
				context.write(sb.toString());

				context.flush();
			}
		} else {
			logger.warn("......run() current socket client connect size={}", 0);
		}
	}

	private FullHttpResponse getResponse(HttpRequest request) {
		FullHttpResponse response = null;
		try {
			String res = "I am OK! " + System.currentTimeMillis();
			response = new DefaultFullHttpResponse(HTTP_1_1,
					OK, Unpooled.wrappedBuffer(res.getBytes("UTF-8")));
			response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
			response.headers().set(HttpHeaderNames.CONTENT_LENGTH,
					response.content().readableBytes());
			if (HttpUtil.isKeepAlive(request)) {
				response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("......getResponse() Caught FullHttpResponse Occurred exception: {}", e.getMessage());
		}
		return response;
	}
}
