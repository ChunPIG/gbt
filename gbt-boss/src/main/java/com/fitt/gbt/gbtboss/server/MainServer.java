package com.fitt.gbt.gbtboss.server;

import com.fitt.gbt.gbtboss.handler.GbtBossHttpServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * <p>@description: 服务</p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Chuck[ZhengCongChun]</p>
 * <p>@created: 2017-10-25</p>
 * <p>@version: 1.0</p>
 */
public class MainServer {
	/**
	 * Socket服务端口
	 */
	private static int serverPort = 9908;

	public static void startServer() throws InterruptedException {
		// Server Socket Channel Master Thread Group(default 2*coreSize)
		EventLoopGroup bossGroup = new NioEventLoopGroup();

		// Accept Channel Worker Thread Group
		NioEventLoopGroup workerGroup = new NioEventLoopGroup();

		// Set I/O percentage
		workerGroup.setIoRatio(50);

		try {
			ServerBootstrap bootstrap = new ServerBootstrap();

			// Set Time Loop Object, BossGroup for Accept Event, WorkerGroup for Connected I/O
			bootstrap.group(bossGroup, workerGroup);

			// for Create new Connect and create serverSocketChannel Factory
			bootstrap.channel(NioServerSocketChannel.class);

			// pre Add inboundHandler for Accept channel pipeline
			bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel channel) {
							System.err.println("******** GBT BOSS Server Start **********");
							channel.config().setAutoRead(true);
							// explain http request message handler
							channel.pipeline().addLast(new HttpRequestDecoder());

							// encode response into http response message sending
							channel.pipeline().addLast(new HttpResponseEncoder());

							// custom define Http handler
							channel.pipeline().addLast(new GbtBossHttpServerHandler());
						}
					}).option(ChannelOption.SO_BACKLOG, 128) // 流控
					.childOption(ChannelOption.SO_KEEPALIVE, true)	;

			// bind method will created serverChannel, and register current channel to EventLoop
			ChannelFuture future = bootstrap.bind(serverPort).sync();

			System.err.println("******** GBT BOSS Server run ********");
			// block util close serverChannel
			future.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
}
