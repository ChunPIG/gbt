package com.fitt.gbt.boss.client;

import com.fitt.gbt.boss.handler.HttpClientInBoundHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.UnsupportedEncodingException;
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
			bootstrap.option(ChannelOption.TCP_NODELAY, true);
			bootstrap.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel channel) throws Exception {
					channel.pipeline().addLast("decoder", new StringDecoder());
					channel.pipeline().addLast("encoder", new StringEncoder());
					channel.pipeline().addLast(new HttpClientInBoundHandler());
				}
			});

			// start the client
			ChannelFuture future = bootstrap.connect(host, port).sync();

			// send http request
			future.channel().writeAndFlush("Hello Netty Server ,I am a common client");
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
