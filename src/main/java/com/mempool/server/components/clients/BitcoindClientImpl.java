package com.mempool.server.components.clients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mempool.server.bitcoind.entities.request.BooleanArrayParamRequest;
import com.mempool.server.bitcoind.entities.request.StringArrayParamRequest;
import com.mempool.server.bitcoind.entities.results.GetMemPoolInfo;
import com.mempool.server.bitcoind.entities.results.GetRawMemPoolNonVerbose;

@Component
public class BitcoindClientImpl implements BitcoindClient {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public GetRawMemPoolNonVerbose getRawMemPoolNonVerbose() {
		BooleanArrayParamRequest boolParams = new BooleanArrayParamRequest();
		boolParams.setId("2");
		boolParams.setMethod("getrawmempool");
		List<Boolean> params = new ArrayList<Boolean>();
		params.add(false);
		boolParams.setParams(params);

		return restTemplate.postForObject("/", boolParams, GetRawMemPoolNonVerbose.class);
	}

	@Override
	public GetMemPoolInfo getMemPoolInfo() {
		StringArrayParamRequest stringParams = new StringArrayParamRequest();

		stringParams.setId("5");
		stringParams.setMethod("getmempoolinfo");
		stringParams.setParams(new ArrayList<String>());

		return restTemplate.postForObject("/", stringParams, GetMemPoolInfo.class);
	}

}
