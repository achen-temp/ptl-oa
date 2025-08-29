package com.ptl.exercise.randstad.test_role;

public class JavaSeleniumAutomation {
    
}

/* 
class TestForAddTodo extends SeleniumTest{

    public void runTest(Object val){
        String todoTitle = (String) val;
        WebElement inputField = getDriver().findElement(By.id("new-todo")); //id NOT ID
        inputField.sendKeys(todoTitle);
        inputField.sendKeys(Keys.ENTER);  //Keys not keys
    }


}

class TestForMarkCompleted extends SeleniumTest {

    public void runTest(Object val) {
        int index = (Integer) val;

        // Find the checkbox to mark the todo as completed
        WebElement todoItem = getDriver().findElements(By.cssSelector("ul#todo-list li")).get(index);
        WebElement checkBox = todoItem.findElement(By.className("toggle"));
        checkBox.click();
    }
}

class TestForDeleteTodo extends SeleniumTest {

    public void runTest(Object val) {
        int index = (Integer) val;
        WebElement todoItem = getDriver().findElements(By.cssSelector("ul#todo-list li")).get(index);
        WebElement deleteButton = todoItem.findElement(By.className("destroy"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", deleteButton);
        deleteButton.click();
    }
}

*/