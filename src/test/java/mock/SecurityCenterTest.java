package mock;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecurityCenterTest {
    /* 需求描述：
    编写SecurityCenter类的单元测试，单元测试switchOn方法，不依赖于DoorPanel的close的方法实现
    * */

     private static class DoorPanelMock extends DoorPanel{
       private boolean flag=false;

        public void close() {
            flag = true;
        }

        public boolean isClosedBeCalled(){
            return flag;
        }

    }
     private SecurityCenter securityCenter;
     private DoorPanelMock doorPanelMock;

    @BeforeEach
    public void setUp() {
         doorPanelMock = new DoorPanelMock();
         securityCenter = new SecurityCenter(doorPanelMock);
    }

    @Test
    public void shouldVerifyDoorIsClosed() {
        securityCenter.switchOn();

        assertTrue(doorPanelMock.isClosedBeCalled());

    }
}
