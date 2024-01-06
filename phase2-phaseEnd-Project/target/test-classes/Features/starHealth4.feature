@StarHealth @SmokeTest
Feature: Test StarHealth Website
  User wants test StarHealth website

  @StarHealth
  Scenario Outline: StarHealth buy now verification
    Given You are on website
    When locate option buy now
    Then click on option buy now
    When enter "<name>" "<phno>" "<pin>" "<email>" in form
    Then click get started

    Examples: 
      | name         | phno       | pin    | email              |
      | Quamar Iqbal | 9931345876 | 711105 | neuro123@gmail.com |
