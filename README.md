# Read-File-App

_ReadFile_ program ingesting a text ﬁle and returns a specific output.This output will depend on the input filter.

### File Format
Each line of the file has the following structure:
1. Starts with F or D.
2. If F, this is a "format" line and two formats can be provided (1 or 2).
3. If D, this is a "data" line whose format is defined by the closest above format line.
4. If "F1" is specified, you can expect these fields separated with a comma:\
    a. D defining a data line\
    b. Name and surname\
    c. City\
    d. ID formatted as "12345678Z"
5. If "F2" is specified, you can expect these fields separated with space-semicolon-space:\
    a. D defining a data line\
    b. Name and surname\
    c. City\
    d. ID formatted as "12345678-Z"
    
### Arguments
1. FILE: Location of FILE.
2. FILTER: Filter to apply while searching (CITY or ID).
3. FILTER VALUE: City name or ID value.

### Installation
1. Clone or download the project in GitHub.
2. Go to project folder.
3. Run the next command to build the project.
    ```bash
        mvn package
    ```

### Commands to support
1. java -jar read-file-app-1.0.jar {FILE} CITY {CITY_NAME} → Will print the list of names and ID's
belonging to people that have been in that city
2. java -jar read-file-app-1.0.jar {FILE} ID {ID_VALUE} (ID format example for input: 12345678Z) →
Will print the list of cities that this person has been to.
#### Example by CITY
###### Input

```bash
java -jar read-file-app-1.0.jar LogFile.txt CITY BARCELONA
```

###### Output
```bash
Erica Burns,93654902Y
Renee Anderson,44340637H
Rhonda Hopkins,54315871-Z
Lowell Miles,04217040J
Russell Pope,69429384C
Shelley Payne,54808168L
Johnathan Cooper,10863096N
Peter Daniel,58204706D
Ruben Daniels,84604786E
Emilio Warner,23803975X
```
#### Example by ID
###### Input

```bash
java -jar read-file-app-1.0.jar LogFile.txt ID 54808168L
```

##### Output
```bash
MADRID
BARCELONA
OVIEDO
```