package com.mju.IdolIns.service.impl;

import com.mju.IdolIns.data.dao.InsuranceCenterDao;
import com.mju.IdolIns.data.dto.insurancecenterdto.InsuranceCenterResponseDto;
import com.mju.IdolIns.data.entity.InsuranceCenter;
import com.mju.IdolIns.service.AccidentDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class AccidentDispatchServiceImpl implements AccidentDispatchService {
    private final InsuranceCenterDao insuranceCenterDao;

    @Autowired
    public AccidentDispatchServiceImpl(InsuranceCenterDao insuranceCenterDao){this.insuranceCenterDao = insuranceCenterDao;}

    @Override
    public String getCenter(String spot) {
        InsuranceCenter insuranceCenter;
        int centerNo = 0;
        double latitude, longitude;
        double distance;

        StringTokenizer stringTokenizer = new StringTokenizer(spot, ",", false);
        latitude = Double.parseDouble(stringTokenizer.nextToken());
        longitude = Double.parseDouble(stringTokenizer.nextToken());

        List<InsuranceCenter> centerList;
        centerList = insuranceCenterDao.getAllInsuranceCenter();
        distance = 999999;

        for (int i=0;i<centerList.size();i++){
            double ctrLatitude, ctrLongitude; String location;
            double distanceWith;

            location = centerList.get(i).getCenterLocation();
            StringTokenizer st = new StringTokenizer(location, ",", false);
            ctrLatitude = Double.parseDouble(st.nextToken());
            ctrLongitude = Double.parseDouble(st.nextToken());

            distanceWith = Math.sqrt((ctrLatitude-latitude)*(ctrLatitude-latitude) +
                    (ctrLongitude-longitude)*(ctrLongitude-longitude));
            if(distanceWith<distance){
                distance = distanceWith;
                centerNo = i;
            }
        }
        insuranceCenter = centerList.get(centerNo);


        return "The closest center is " + insuranceCenter.getCenterName()+ ". The Address is "
                +insuranceCenter.getCenterAddress()+"And You can call dispatch via this number ("
                +insuranceCenter.getCenterHotline()+")";
    }
}
