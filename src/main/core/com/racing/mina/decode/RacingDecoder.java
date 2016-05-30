package com.racing.mina.decode;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class RacingDecoder extends CumulativeProtocolDecoder {

	private final Charset charset;

	public RacingDecoder(Charset charset) {
		this.charset = charset;
	}

	public boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		CharsetDecoder cd = charset.newDecoder();
		String mes = in.getString(cd);
		out.write(mes);
		return true;
	}

}
