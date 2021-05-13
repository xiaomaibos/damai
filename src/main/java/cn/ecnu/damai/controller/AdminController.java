package cn.ecnu.damai.controller;

import cn.ecnu.damai.entity.Level;
import cn.ecnu.damai.entity.Program;
import cn.ecnu.damai.entity.Show;
import cn.ecnu.damai.service.LevelService;
import cn.ecnu.damai.service.ProgramService;
import cn.ecnu.damai.service.ShowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kyrie Lee
 * @date 2021/5/13 14:37
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Resource
    private ProgramService programService;
    @Resource
    private ShowService showService;
    @Resource
    private LevelService levelService;

    @RequestMapping("/addProgram")
    @ResponseBody
    public Map<String, Object> addProgram(String startTime, String endTime,
                                          String imageUrl, Program program) throws ParseException {
        Map<String, Object> messageMap = new HashMap<>(8);
        program.setImage(imageUrl);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        program.setStartTime(format.parse(startTime));
        program.setEndTime(format.parse(endTime));
        int num = programService.addProgram(program);
        if (num == 1) {
            messageMap.put("success", true);
            messageMap.put("programId", program.getPid());
            return messageMap;
        }
        messageMap.put("success", false);
        return messageMap;
    }


    @RequestMapping("/addShow")
    @ResponseBody
    public Map<String, Object> addShow(Show show) {
        Map<String, Object> messageMap = new HashMap<>(8);
        int num = showService.addShow(show);
        if (num == 1) {
            messageMap.put("success", true);
            messageMap.put("code", 1);
            messageMap.put("message", "添加成功");
            return messageMap;
        }
        messageMap.put("success", false);
        messageMap.put("code", 300);
        messageMap.put("message", "添加失败");
        return messageMap;
    }


    @RequestMapping("/addLevel")
    @ResponseBody
    public Map<String, Object> addLevel(Level level) {
        Map<String, Object> messageMap = new HashMap<>(8);
        int num = levelService.addLevel(level);
        if (num == 1) {
            messageMap.put("success", true);
            messageMap.put("code", 1);
            messageMap.put("message", "添加成功");
            return messageMap;
        }
        messageMap.put("success", false);
        messageMap.put("code", 300);
        messageMap.put("message", "添加失败");
        return messageMap;
    }
}
