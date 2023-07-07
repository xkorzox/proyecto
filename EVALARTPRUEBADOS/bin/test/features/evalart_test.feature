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
@tag
Feature: Submit all the forms calculating the correct result
  I want to submit all the forms calculating the correct result

  @tag1
  Scenario Outline: Submit all the forms calculating the correct result
    Given Login evalart automation test page "Evalart Test"
      | user  | 592179                                           |
      | password | 10df2f32286b7120Mi00LTk3MTI5NQ==30e0c83e6c29f1c3 |
    When Do ten iterations submiting the forms with correct results
    Then Validate success message
  