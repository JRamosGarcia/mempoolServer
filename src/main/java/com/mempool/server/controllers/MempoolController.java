package com.mempool.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mempool.server.bitcoind.entities.results.GetMemPoolInfoData;
import com.mempool.server.components.clients.BitcoindClient;

@RestController
@RequestMapping("/memPool")
public class MempoolController {

	@Autowired
	private BitcoindClient bitcoindClient;
	
	@GetMapping("/info")
	public GetMemPoolInfoData getMemPoolInfo() {
		return bitcoindClient.getMemPoolInfo().getGetMemPoolInfoData();
	}

	
}
