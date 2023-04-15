package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("marusya@gmail.com").withPassword("Mmar123456$"));
        }
//        app.helperContact().provideContacts();//if less then 3 ===> add 3 contacts
    }



    @Test
    public void removeFirstContact(){

    }

    @Test
    public void removeAllContacts(){

    }

}