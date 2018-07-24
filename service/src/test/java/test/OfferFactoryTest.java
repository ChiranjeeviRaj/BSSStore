package test;

import org.junit.Assert;
import org.junit.Test;
import uk.bss.store.model.OfferType;
import uk.bss.store.service.OfferService;
import uk.bss.store.service.factory.OfferFactory;
import uk.bss.store.service.impl.MutiBuyLinkProdOfferServiceImpl;
import uk.bss.store.service.impl.NoOfferServiceImpl;
import uk.bss.store.service.impl.PercetageOfferServiceImpl;

public class OfferFactoryTest {

    OfferFactory offerFactory;
    OfferService offerService;

    @Test
    public void testPerRedServceTestValid(){
        offerService = offerFactory.getOfferService(OfferType.PER_RED);
        Assert.assertNotNull(offerService);
        Assert.assertTrue(PercetageOfferServiceImpl.class.isInstance(offerService));
    }

    @Test
    public void testPerRedServceTestInValid(){
        offerService = offerFactory.getOfferService(OfferType.MULTI_BUY_LNK_PROD);
        Assert.assertNotNull(offerService);
        Assert.assertTrue(!PercetageOfferServiceImpl.class.isInstance(offerService));
    }

    @Test
    public void testMultiBuyServceTestValid(){
        offerService = offerFactory.getOfferService(OfferType.MULTI_BUY_LNK_PROD);
        Assert.assertNotNull(offerService);
        Assert.assertTrue(MutiBuyLinkProdOfferServiceImpl.class.isInstance(offerService));
    }

    @Test
    public void testMultiBuyServceTestInValid(){
        offerService = offerFactory.getOfferService(OfferType.PER_RED);
        Assert.assertNotNull(offerService);
        Assert.assertTrue(!MutiBuyLinkProdOfferServiceImpl.class.isInstance(offerService));
    }

    @Test
    public void testWhenNoOfferValid(){
        offerService = offerFactory.getOfferService(null);
        Assert.assertNotNull(offerService);
        Assert.assertTrue(NoOfferServiceImpl.class.isInstance(offerService));
    }
}
