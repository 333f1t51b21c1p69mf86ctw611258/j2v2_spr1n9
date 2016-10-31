package my.henrik.device;

import my.henrik.support.web.MessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by levin86 on 10/25/2016.
 */
@Controller(value = "deviceController")
public class DeviceController {

    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    public String list(Model model) {
        System.out.println("Returning devices:");

        MessageHelper.addInfoAttribute(model, "test.message1");

        return "device/devices";
    }

}