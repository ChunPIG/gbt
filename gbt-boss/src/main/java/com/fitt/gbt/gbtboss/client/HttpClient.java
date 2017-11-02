package com.fitt.gbt.gbtboss.client;

import com.fitt.gbt.gbtboss.handler.HttpClientInBoundHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpVersion;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * <p>@description: 客户端</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-10-26</p>
 * <p>@version: 1.0</p>
 */
public class HttpClient {
	public void connect(String host, int port) throws InterruptedException, URISyntaxException, UnsupportedEncodingException {
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(workerGroup);
			bootstrap.channel(NioSocketChannel.class);
			bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
			bootstrap.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel channel) throws Exception {
					channel.pipeline().addLast(new HttpRequestDecoder());
					channel.pipeline().addLast(new HttpResponseEncoder());
					channel.pipeline().addLast(new HttpClientInBoundHandler());
				}
			});

			// start the client
			ChannelFuture future = bootstrap.connect(host, port).sync();

			URI uri = new URI("http://127.0.0.1:9908");
			String msg = "Are you Ok?";
			DefaultFullHttpRequest request = new DefaultFullHttpRequest(
					HttpVersion.HTTP_1_1,
					HttpMethod.GET, uri.toASCIIString(),
					Unpooled.wrappedBuffer(msg.getBytes("UTF-8")));
			// create http request
			request.headers().set(HttpHeaders.Names.HOST, host);
			request.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
			request.headers().set(HttpHeaders.Names.CONTENT_LENGTH, request.content().readableBytes());

			// send http request
			future.channel().write(request);
			future.channel().flush();
			future.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {
		HttpClient client = new HttpClient();
		client.connect("127.0.0.1", 9908);
	}
}
