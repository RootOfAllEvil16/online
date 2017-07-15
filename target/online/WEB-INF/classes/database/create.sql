CREATE TABLE project.users (
  userId   INTEGER NOT NULL AUTO_INCREMENT,
  userName VARCHAR(255),
  password VARCHAR(20),
  email    VARCHAR(255),
  enabled  TINYINT,
  PRIMARY KEY (userId)
);
CREATE TABLE project.authorities (
  authorityId INTEGER NOT NULL AUTO_INCREMENT,
  authority   VARCHAR(255),
  userName    VARCHAR(255),
  PRIMARY KEY (authorityId)

);
CREATE TABLE project.comments (
  commentId   INTEGER NOT NULL AUTO_INCREMENT,
  comment     VARCHAR(20000),
  commentDate DATETIME         DEFAULT current_timestamp,
  userId      INTEGER,
  episodeId   INTEGER,
  PRIMARY KEY (commentId)
);
CREATE TABLE project.episodes (
  episodeId    INTEGER NOT NULL AUTO_INCREMENT,
  episodeNum   INTEGER,
  seasonId       INTEGER,
  PRIMARY KEY (episodeId)

);
CREATE TABLE project.seasons (
  seasonId  INTEGER NOT NULL AUTO_INCREMENT,
  seasonNum INTEGER,
  showId INTEGER,
  PRIMARY KEY (seasonId)
);
CREATE TABLE project.shows (
  showId    INTEGER NOT NULL AUTO_INCREMENT,
  showName  VARCHAR(255),
  genre     VARCHAR(255),
  PRIMARY KEY (showId)
);



ALTER TABLE seasons
  ADD INDEX (showId),
  ADD FOREIGN KEY (showId)REFERENCES shows(showId);

ALTER TABLE episodes
  ADD INDEX (seasonId),
  ADD FOREIGN KEY (seasonId)REFERENCES seasons(seasonId);

ALTER TABLE comments
  ADD INDEX (episodeId),
  ADD FOREIGN KEY (episodeId)REFERENCES episodes(episodeId);

ALTER TABLE comments
  ADD INDEX (userId),
  ADD FOREIGN KEY (userId)REFERENCES users(userId);




