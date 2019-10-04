public class Xpaths {
    public String MAINPAGE = "http://www.sberbank.ru/ru/person";
    public String INSURANCE = "//*[@class='lg-menu__text'][text()='Страхование']";
    public String TRAVELERS = "//*[@class='lg-menu__sub-link'][text()[contains(.,'путешественников')]]";
    public String HEADER = "//*[@class='sbrf-rich-outer']/h1";
    public String ONLINE = "//*[@target='_blank']/img";
    public String MIN = "//*[@class='b-form-prog-note ng-binding']";
    public String FORMALIZE = "//*[@ng-click='save()']";
    public String FORM = "//*[@name='%s']";
    public String SURNAME_OF = "insured0_surname";
    public String NAME_OF = "insured0_name";
    public String BIRHTDAY_OF = "insured0_birthDate";
    public String SURNAME = "surname";
    public String NAME = "name";
    public String MIDNAME = "middlename";
    public String BIRTHDAY = "birthDate";
    public String GENDER = "male";
    public String PASSPORT = "passport_series";
    public String PASSPORTN = "passport_number";
    public String ISSUEDATE = "issueDate";
    public String ISSUEPLACE = "issuePlace";
    public String CORRECT = " //*[contains(@class,'b-erroneous-text-field')]";
    public String CONTINUE = "//*[@ng-click='save()']";
    public String ALLERT = "//*[@ng-show='tryNext && myForm.$invalid']";
}
