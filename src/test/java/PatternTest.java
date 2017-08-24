import ewan.study.service.LazyInitHolderSingleton;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ewan on 24/08/2017.
 */
public class PatternTest {
    @Test
    public void TestLazyInitHolderSingleton() {
        Assert.assertFalse(new String("123") == new String("123"));
        //单例
        Assert.assertTrue(LazyInitHolderSingleton.getInstance() == LazyInitHolderSingleton.getInstance());
    }
}
