Feature: Enregistrement d'un étudinat

  Scenario: Création d'un étudiant
    Given aucune immatriculation d'étudiant
    When l'immatriculation de l'étudiant "Arnaud" "Geiser" avec le No SIUS "1422-12"
    Then l'étudiant avec le No SIUS "1422-12" doit exister
    When il ne doit pas être possible d'immatriculer l'étudiant "Stéphane" "Biolley" avec le No SIUS "1422-12"