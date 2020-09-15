package stub;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GradeServiceTest {
    /* 需求描述：
    编写GradeService类的单元测试，单元测试calculateAverageGrades方法
    * */
    class GradeStubs extends GradeSystem{

        public List<Double> gradesFor(long studentId) {

            return Arrays.asList(80.0,90.0,100.0); // 只是一个例子
        }
    }
    @Test
    public void shouldReturn90WhenCalculateStudentAverageGradeAndGradeIs80And90And100() {
        GradeService gradeService = new GradeService(new GradeStubs());
        double result = gradeService.calculateAverageGrades(161008);
        Assertions.assertEquals(90.0, result);
    }
}
