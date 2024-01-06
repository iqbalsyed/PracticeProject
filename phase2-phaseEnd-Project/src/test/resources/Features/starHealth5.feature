@StarHealth @SmokeTest
Feature: Test StarHealth Website
  User wants test StarHealth website

  @StarHealth
  Scenario Outline: StarHealth Family Plan
    Given Launch website
    When hover on plans
    Then click on family plan
