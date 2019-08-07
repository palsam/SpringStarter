package com.palani.springmongo.service.impl;

import com.palani.springmongo.service.SalesService;
import com.palani.springmongo.util.PaymentTypeEnum;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.palani.springmongo.domain.Sales;
import com.palani.springmongo.log.ActionEnum;
import com.palani.springmongo.log.LogUtil;
import com.palani.springmongo.repository.SalesRepository;
import com.palani.springmongo.resource.response.dto.SalesDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SalesServiceImpl implements SalesService{
	
	private SalesRepository salesRepository;
	private LogUtil logUtil;
	
	@Autowired
	public SalesServiceImpl(SalesRepository salesRepository,LogUtil logUtil) {
		this.salesRepository = salesRepository;
		this.logUtil = logUtil;
	}

	@Override
	public List<SalesDTO> getSales() {
		/*
		 * logUtil.logInfo(log,ActionEnum.GET_DATA, "Get all the salse Data");
		 * List<SalesDTO> as = new ArrayList<SalesDTO>(); SalesDTO s1 = new SalesDTO();
		 * s1.setSaleId("1"); s1.setNumberOfItems(2); s1.setSaleAmount(25.4);
		 * s1.setPaymentType(PaymentTypeEnum.CREDIT.toString()); as.add(s1); return as;
		 */
		 
		
		
		  List<SalesDTO> salesList = null; List<Sales> sales =
		  salesRepository.findAll(); if(null!=sales &&
		  !sales.isEmpty()) { salesList = new ArrayList<>(); for(Sales sale:sales) {
		  SalesDTO saleDto = new SalesDTO(); saleDto.setSaleId(sale.getId());
		  saleDto.setNumberOfItems(sale.getNumberOfItems());
		  saleDto.setPaymentType(sale.getPaymentType());
		  saleDto.setSaleAmount(sale.getSaleAmount()); salesList.add(saleDto); } }
		  return salesList;
		 
		 }
}
