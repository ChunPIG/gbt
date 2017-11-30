package com.fitt.gbt.boss.handler;

import com.fitt.gbt.boss.cache.SocketCache;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>@description: Http Socket 通讯处理类</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-10-25</p>
 * <p>@version: 1.0</p>
 */
public class GbtBossHttpServerHandler extends ChannelInboundHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(GbtBossHttpServerHandler.class);

	private HttpRequest request;

	@Override
	public void channelRead(ChannelHandlerContext context, Object message) throws Exception {
		logger.info(context.channel().remoteAddress() + "->Server :" + message.toString());
		context.writeAndFlush("server write" + message);
		if (!SocketCache.contains(context)) {
			int uniqueID = SocketCache.getUniqueID();
			SocketCache.set(uniqueID, context);
		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.info("********** Channel Read Complete **********");
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.error("......exceptionCaught() Channel Occurred Exception: ", cause.getMessage());
		SocketCache.remove(ctx);
		ctx.close();
	}
}
