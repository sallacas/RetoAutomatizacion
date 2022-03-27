# language: en
# Author: Johnatan David Casallas Silva

Feature: Create a business on StartSharp and be able to generate meetings on StartSharp.

  Scenario: Meeting created in the generated business unit
    Given Juan navigate to the page
    When he sends their valid credentials
    And he should enter the dashboard and go to business section
    And he enters he creates the business Mazino
    And he validates the creation of the business and goes to the meeting module
    And he creates a new meeting for the business Mazino with data Type Strategy Date 03/30/2022 Times 08:00 09:00 Location SD-01
    Then he finds his meeting created
