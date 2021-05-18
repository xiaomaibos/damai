package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Address;

public interface AddressService {

    Address addAddress(Address address);

    boolean deleteAddress(Integer addressId);

    Address getAddress(Integer addressId);
}
