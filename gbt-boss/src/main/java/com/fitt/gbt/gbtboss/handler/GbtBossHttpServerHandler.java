package com.fitt.gbt.gbtboss.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * <p>@description: Http Socket 通讯处理类</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-10-25</p>
 * <p>@version: 1.0</p>
 */
public class GbtBossHttpServerHandler extends ChannelInboundHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(GbtBossHttpServerHandler.class);

	private HttpRequest request;

	@Override
	public void channelRead(ChannelHandlerContext context, Object message) throws Exception {
		if (message instanceof HttpRequest) {
			request = (HttpRequest) message;
			String uri = request.getUri();
			System.out.println("request uri: " + uri);
			logger.info("......channelRead() request uri: {}", uri);
		}
		if (message instanceof HttpContent) {
			HttpContent content = (HttpContent) message;

			ByteBuf buf = content.content();
			String reqContent = buf.toString(CharsetUtil.UTF_8);
			logger.info(".......channelRead() request content: {}", reqContent);
			buf.release();

			String res = "I am OK";
			FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1,
					OK, Unpooled.wrappedBuffer(res.getBytes("UTF-8")));
			response.headers().set(CONTENT_TYPE, "text/plain");
			response.headers().set(CONTENT_LENGTH,
					response.content().readableBytes());
			if (HttpHeaders.isKeepAlive(request)) {
				response.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
			}
			context.write(response);
			context.flush();
		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.err.println("********** Channel Read Complete **********");
		logger.info("********** Channel Read Complete **********");
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.err.println("********** Channel Read Occurred Exception **********");
		logger.error("********** Channel Read Occurred Exception **********", cause.getMessage());
		ctx.close();
	}
}
