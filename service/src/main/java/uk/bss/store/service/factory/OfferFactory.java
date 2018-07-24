package uk.bss.store.service.factory;

import uk.bss.store.model.OfferType;
import uk.bss.store.service.OfferService;
import uk.bss.store.service.impl.MutiBuyLinkProdOfferServiceImpl;
import uk.bss.store.service.impl.NoOfferServiceImpl;
import uk.bss.store.service.impl.PercetageOfferServiceImpl;

/**
 * This Factory class returns Offer Impl using offer type
 */
public class OfferFactory {
    /**
     * This methods returns Offer Impl using Offer Type, When the offer type is null return @{@link NoOfferServiceImpl}
     * @param offerType is Enum is the input to decides the offer type and the filed can be null
     * @return OfferService Impl
     */
    public static OfferService getOfferService(OfferType offerType){
        if(offerType == null){
            return new NoOfferServiceImpl();
        }
        switch (offerType){
            case PER_RED: return new PercetageOfferServiceImpl();
            case MULTI_BUY_LNK_PROD: return new MutiBuyLinkProdOfferServiceImpl();
            default: return null;
        }
    }
}
