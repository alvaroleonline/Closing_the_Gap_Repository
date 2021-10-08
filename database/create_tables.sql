PRAGMA foreign_keys = OFF;
drop table if exists PopulationStatistics;
PRAGMA foreign_keys = ON;

CREATE TABLE PopulationStatistics (
    lga_code16        INTEGER NOT NULL,
    indigenous_status TEXT NOT NULL,
    sex               CHAR (1) NOT NULL,
    age               TEXT NOT NULL,
    count             INTEGER NOT NULL,
    PRIMARY KEY (lga_code16, indigenous_status, sex, age)
    FOREIGN KEY (lga_code16) REFERENCES LGAs(lga_code16)
);

