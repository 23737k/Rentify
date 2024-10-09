package com.nocountry.rentify.service;

import com.nocountry.rentify.dto.mapper.PropertyMapper;
import com.nocountry.rentify.dto.request.property.PropertyReq;
import com.nocountry.rentify.dto.response.property.PropertyRes;
import com.nocountry.rentify.service.interfaces.PropertyService;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class PropertyServiceImpl implements PropertyService {

  private final PropertyMapper mapper;

  @Override
  public List<PropertyRes> getAllProperties() {
    return List.of();
  }

  @Override
  public PropertyRes getProperty(Long id) {
    return null;
  }

  @Override
  public PropertyRes addProperty(PropertyReq property) {
    return null;
  }

  @Override
  public PropertyRes updateProperty(Long id, PropertyReq property) {
    return null;
  }

  @Override
  public void deleteProperty(Long id) {

  }
}
