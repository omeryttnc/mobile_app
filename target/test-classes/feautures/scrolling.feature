Feature: Api demos
  Background: test sayfasina kadar olan adimlar
    Given App telefonda acilsin
    Then kullanici API demos tiklasin
    Then  kullanici Views tiklasin

  Scenario: Scroll to element and click
    Then kullanici Switches tiklasin
    Then kullanci app kapatsin


  @single
  Scenario: UIscrollable ile
    Then  kullanici UiScrolable ile Switches tiklasin
    Then kullanci app kapatsin


  @WebView
  Scenario: UIscrollable  ile
    Then  kullanici UiScrolable ile "WebView" tiklasin
    Then kullanci app kapatsin
