package Wissen.JUnitTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ArrayTesting.class,TestFunction.class,TestFunction2.class})

public class TestSuite {

}
