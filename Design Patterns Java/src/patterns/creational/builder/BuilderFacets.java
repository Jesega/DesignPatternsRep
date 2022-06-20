package patterns.creational.builder;

class Person2
{
  // address
  public String streetAddress, postcode, city;

  // employment
  public String companyName, position;
  public int annualIncome;

  @Override
  public String toString()
  {
    return "Person2{" +
      "streetAddress='" + streetAddress + '\'' +
      ", postcode='" + postcode + '\'' +
      ", city='" + city + '\'' +
      ", companyName='" + companyName + '\'' +
      ", position='" + position + '\'' +
      ", annualIncome=" + annualIncome +
      '}';
  }
}

// builder facade
class Person2Builder
{
  // the object we're going to build
  protected Person2 person2 = new Person2(); // reference!

  public Person2JobBuilder works()
  {
    return new Person2JobBuilder(person2);
  }

  public Person2AddressBuilder lives()
  {
    return new Person2AddressBuilder(person2);
  }

  public Person2 build()
  {
    return person2;
  }
}

class Person2AddressBuilder extends Person2Builder
{
  public Person2AddressBuilder(Person2 Person2)
  {
    this.person2 = Person2;
  }

  public Person2AddressBuilder at(String streetAddress)
  {
    person2.streetAddress = streetAddress;
    return this;
  }

  public Person2AddressBuilder withPostcode(String postcode)
  {
    person2.postcode = postcode;
    return this;
  }

  public Person2AddressBuilder in(String city)
  {
    person2.city = city;
    return this;
  }
}

class Person2JobBuilder extends Person2Builder
{
  public Person2JobBuilder(Person2 Person2)
  {
    this.person2 = Person2;
  }

  public Person2JobBuilder at(String companyName)
  {
    person2.companyName = companyName;
    return this;
  }

  public Person2JobBuilder asA(String position)
  {
    person2.position = position;
    return this;
  }

  public Person2JobBuilder earning(int annualIncome)
  {
    person2.annualIncome = annualIncome;
    return this;
  }
}

class BuilderFacetsDemo
{
  public static void main(String[] args)
  {
    Person2Builder pb = new Person2Builder();
    Person2 Person2 = pb
      .lives()
        .at("123 London Road")
        .in("London")
        .withPostcode("SW12BC")
      .works()
        .at("Fabrikam")
        .asA("Engineer")
        .earning(123000)
      .build();
    System.out.println(Person2);
  }
}