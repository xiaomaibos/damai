package cn.ecnu.damai.service.impl;

import cn.ecnu.damai.dao.repository.AddressRepository;
import cn.ecnu.damai.entity.Address;
import cn.ecnu.damai.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressRepository addressRepository;

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public boolean deleteAddress(Integer addressId) {
        Optional<Address> optAddress = addressRepository.findById(addressId);
        if (optAddress.isPresent()) {
            Address address = optAddress.get();
            address.setIsDelete(1);
            addressRepository.save(address);
            return true;
        }
        return false;
    }

    @Override
    public Address getAddress(Integer addressId) {
        Optional<Address> optAddress = addressRepository.findById(addressId);
        if (optAddress.isPresent()) {
            Address address = optAddress.get();
            if (address.getIsDelete() == 0) {
                return address;
            }
        }
        return null;
    }

}
