package bla.tm.steps.products_and_docs;

import bla.tm.pages.AncestorPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class PD_CommonSteps extends WidgetFields {

    AncestorPage ancestorPage;

    public void changeValuesForAllFields(String apiKey, String keyword, String zipCode, String city, String attractionId, String venueId, String promoterId, String source, String countryCode, String classificationName, String eventCount) {
        ancestorPage.getWidget().setApiKeyValue(apiKey);
        ancestorPage.getWidget().setKeywordValue(keyword);
        ancestorPage.getWidget().setZipCodeValue(zipCode);
        ancestorPage.getWidget().setCityValue(city);
        ancestorPage.getWidget().setAttractionIdValue(attractionId);
        ancestorPage.getWidget().setVenueIdValue(venueId);
        ancestorPage.getWidget().setPromoterIdValue(promoterId);
        ancestorPage.getWidget().setSourceValue(source);
        ancestorPage.getWidget().setCountryCodeValue(countryCode);
        ancestorPage.getWidget().setClassificationNameValue(classificationName);
        ancestorPage.getWidget().setEventCountValue(eventCount);
    }

    public String getCountryNameByCode(String countryCode) {
        Map<String, String> countryCodes = new HashMap<>();
        countryCodes.put("CA", "Canada");
        countryCodes.put("AU", "Australia");
        countryCodes.put("GB", "Great Britain");
        countryCodes.put("IE", "Ireland");
        countryCodes.put("NZ", "New Zealand");
        countryCodes.put("US", "United States");
        return countryCodes.get(countryCode);
    }

    @Step
    public void fieldEqualsStoredValue(String fieldName) {
        String storedValue = (String) Serenity.getCurrentSession().get(fieldName);
        String fieldValue;
        switch (fieldName){
            case "apiKey": fieldValue = ancestorPage.getCountDownWidget().getAPIKeyTextFieldValue();
                break;
            case "keyword": fieldValue = ancestorPage.getCountDownWidget().getKeywordTextFieldValue();
                break;
            case "zipCode": fieldValue = ancestorPage.getCountDownWidget().getZipCodeTextFieldValue();
                break;
            default: throw new IllegalArgumentException(String.format("Invalid field name argument %s", fieldName));
        }
        assertTrue(String.format("The field (%s) equal %s but it does not equal stored value (%s).", fieldName, fieldValue, storedValue), storedValue.equalsIgnoreCase(fieldValue));
    }

}
