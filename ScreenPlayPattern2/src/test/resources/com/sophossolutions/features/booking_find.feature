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
Feature: Buscar un hotel

  @tag1
  Scenario Outline: Ingresar datos para buscar un hotel
    Given "Nico" sets the Booking url "Booking"
    When Yo ingreso los datos para buscar el alojamiento
      | destino    | <destino>    |
      | ida        | <ida>        |
      | vuelta     | <vuelta>     |
      | numAdultos | <numAdultos> |
      | numNiños   | <numNiños>   |
      | edadNiños  | <edadNiños>  |
      | numHabita  | <numHabita>  |
    And Yo filtro segun la necesidad y selecciono el hotel
      | filtro | <filtro> |
    Then Se imprime por consolo los datos del hotel reservado

    Examples: 
      | destino  | ida        | vuelta     | numAdultos | numNiños | edadNiños | numHabita | filtro |
      | "Cali"   | 2023-04-26 | 2023-05-03 |          3 |        2 | 2-4       |         2 |      1 |
      | "Cancún" | 2023-05-31 | 2023-06-07 |          1 |        1 |         5 |         1 |      2 |
