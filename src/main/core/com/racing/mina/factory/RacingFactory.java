package com.racing.mina.factory;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import com.racing.mina.decode.RacingDecoder;
import com.racing.mina.encode.RacingEncoder;

public class RacingFactory implements ProtocolCodecFactory {

	private final ProtocolEncoder encoder;
	private final ProtocolDecoder decoder;
	private final String encoding = "UTF-8";

	public RacingFactory() {
		encoder = new RacingEncoder(Charset.forName(encoding));
		decoder = new RacingDecoder(Charset.forName(encoding));
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession paramIoSession) throws Exception {
		return encoder;
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession paramIoSession) throws Exception {
		return decoder;
	}

}
