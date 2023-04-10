package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preCondition(){

        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void RegistrationSuccess(){
        Random r = new Random();
        int i = r.nextInt(10000)+1000 ;
        User user = new User().withEmail("fon"+i+"@gmail.com").withPassword("Fon12345$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());

    }

    @Test
    public void RegistrationWrongEmail(){
        User user = new User().withEmail("fongmail.com").withPassword("Fon12345$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

Assert.assertTrue(app.getHelperUser().isAlertPresent2("Wrong email or password"));
    }

    @Test
    public void RegistrationWrongPassword(){
        User user = new User().withEmail("marusya@gmail.com").withPassword("Mmar123456$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent2("User already exist"));
    }

    @Test
    public void RegistrationExistUser(){
        User user = new User().withEmail("fon@gmail.com").withPassword("Fon12$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent2("Wrong email or password"));
    }
}
