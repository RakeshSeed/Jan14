#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.max 9 feature 
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
Feature:     Amazon  guest user
  
  @tag1
  Scenario: Search  by guest user

    Given google chrome is open 

    And amazon.in is open

    When I search oneplus 9r 

    And click on that oneplus 9r link

    And  another window open

    Then guest user switch to other window 

    And click buy now validate sigin is opened 




 