#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@StarHealth @SmokeTest
Feature: Test StarHealth Website
  User wants test StarHealth website

  @StarHealth
  Scenario Outline: Starhealth siteurl and pagetitle verification
    Given Launch chrome
    # And Maximize the Chrome browser window
    When Enter url "<site_url>" and open website
    Then Verify page title "<page_title>"

    Examples: 
      | site_url                   | page_title                                                             | name         | phno       | pin    | email              |
      | https://www.starhealth.in/ | Star Health Insurance: Medical, Accident and Travel insurance policies | Quamar Iqbal | 9931345876 | 711105 | neuro123@gmail.com |
