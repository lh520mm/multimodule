package service.impl;

import commons.CodeMessage;
import dao.StudentMapper;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import response.StudyResponse;
import service.StudentService;

import java.util.List;

/**
 * Created by liuhao on 2017/7/6.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudyResponse getStudents() {
        StudyResponse studyResponse=new StudyResponse();
        try {
            List<Student>students=studentMapper.getStudentAll();
          if(students!=null&&students.size()>0)
          {
              studyResponse.setData(students);
          }else{
              studyResponse.checkSuccess(false, CodeMessage.STUDENT_TEST_ERR.name());
          }
        } catch (Exception e) {
            e.printStackTrace();
         studyResponse.checkSuccess(false,CodeMessage.SYSTEM_ERR.name());studyResponse.setData(e);
        }
        return  studyResponse;
    }



}
