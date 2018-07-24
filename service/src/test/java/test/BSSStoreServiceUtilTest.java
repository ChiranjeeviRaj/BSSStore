package test;

import org.junit.Assert;
import org.junit.Test;
import uk.bss.store.service.model.Basket;
import uk.bss.store.service.util.BSSStoreServiceUtil;

import java.math.BigDecimal;

public class BSSStoreServiceUtilTest {

    @Test
    public void testGetPenseWhenTheValueIsLessThan1pThenNoDecimals(){
        BigDecimal pense = BSSStoreServiceUtil.getPense(new BigDecimal(0.1));
        Assert.assertNotNull(pense);
        Assert.assertEquals(new BigDecimal("10"), pense);
    }

    @Test
    public void testGetPenseWhenTheValueIsGreaterThan1pThenNoDecimals(){
        BigDecimal pense = BSSStoreServiceUtil.getPense(new BigDecimal(1.00));
        Assert.assertNotNull(pense);
        Assert.assertEquals(new BigDecimal("100"), pense);
    }

    @Test
    public void testGetPenseWhenTheValueIsGreaterThan2pThenNoDecimals(){
        BigDecimal pense = BSSStoreServiceUtil.getPense(new BigDecimal(2.00));
        Assert.assertNotNull(pense);
        Assert.assertEquals(new BigDecimal("200"), pense);
    }

    @Test
    public void testGetPoundWhenTheValueIsGreaterThan1pdunfThenDecimals(){
        BigDecimal pense = BSSStoreServiceUtil.getPounds(new BigDecimal(100));
        Assert.assertNotNull(pense);
        Assert.assertEquals(new BigDecimal("1.00"), pense);
    }

    @Test
    public void testGetPoundWhenTheValueIsGreaterThan1pdThenDecimals(){
        BigDecimal pense = BSSStoreServiceUtil.getPounds(new BigDecimal(110));
        Assert.assertNotNull(pense);
        Assert.assertEquals(new BigDecimal("1.10"), pense);
    }

    @Test
    public void testGetPoundWhenTheValueIsLessThan1pdThenDecimals(){
        BigDecimal pense = BSSStoreServiceUtil.getPounds(new BigDecimal(60));
        Assert.assertNotNull(pense);
        Assert.assertEquals(new BigDecimal("0.60"), pense);
    }
}
