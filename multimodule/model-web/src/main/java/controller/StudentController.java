package controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import response.StudyResponse;
import service.StudentService;

import java.util.List;

/**
 * Created by liuhao on 2017/7/6.
 */
@Api(value = "test", tags = "test", description = "测试")
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "测试学生列表", notes = "测试学生列表", nickname = "liuhao", httpMethod = "GET")
    @RequestMapping(value = "stu",method = RequestMethod.GET)
    @ResponseBody
    public StudyResponse show()
    {
        StudyResponse studyResponse=new StudyResponse();
        studyResponse=studentService.getStudents();
        return  studyResponse;
    }
}
