package com.racing.mina.encode;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class RacingEncoder implements ProtocolEncoder {
	private final static Logger log = Logger.getLogger(RacingEncoder.class);

	private final Charset charset;

	public RacingEncoder(Charset charset) {
		this.charset = charset;
	}

	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {

		CharsetEncoder ce = charset.newEncoder();
		String mes = (String) message;
		IoBuffer buffer = IoBuffer.allocate(100).setAutoExpand(true);
		buffer.putString(mes, ce);
		buffer.flip();
		out.write(buffer);
	}

	@Override
	public void dispose(IoSession session) throws Exception {
		log.info("Dispose called,session is " + session);
	}

}
