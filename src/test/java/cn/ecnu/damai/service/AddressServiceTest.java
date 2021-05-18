package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Address;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void testAddAddress() {
        Address address = new Address();
        address.setName("钟小浩");
        address.setPhone("15079084000");
        address.setDetail("江西省");
        address.setUserId(10);
        System.out.println(JSON.toJSONString(addressService.addAddress(address)));
    }

    @Test
    public void testDeleteAddress() {
        addressService.deleteAddress(2);
    }
}
