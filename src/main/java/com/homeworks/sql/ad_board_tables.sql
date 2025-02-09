USE ad_board;


-- Table for Heading
CREATE TABLE Heading (
    heading_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table for Email
CREATE TABLE Email (
    email_id INT AUTO_INCREMENT PRIMARY KEY,
    email_address VARCHAR(255) NOT NULL
);

-- Table for Phone
CREATE TABLE Phone (
    phone_id INT AUTO_INCREMENT PRIMARY KEY,
    phone_number VARCHAR(20) NOT NULL,
    FK_Phone_Author INT 
);

-- Table for Author
CREATE TABLE Author (
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    FK_Author_Email INT  
);

-- Table for Address
CREATE TABLE Address (
    address_id INT AUTO_INCREMENT PRIMARY KEY,
    district VARCHAR(255),
    city VARCHAR(255),
    street VARCHAR(255),
    FK_Address_Author INT UNIQUE  
);

-- Table for Ad
CREATE TABLE Ad (
    ad_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    publication_date DATE,
    content TEXT,
    price DECIMAL(10, 2),
    FK_Ad_Heading INT, 
    FK_Ad_Author INT,
    is_active BOOLEAN
);

-- Table for Matching_ad
CREATE TABLE Matching_ad (
    mad_id INT AUTO_INCREMENT PRIMARY KEY,
    FK_Mad_Author INT,  
    FK_Mad_Heading INT,  
    price_from DECIMAL(10, 2),
    price_to DECIMAL(10, 2),
    subject VARCHAR(255)
);


ALTER TABLE Phone
ADD CONSTRAINT fk_phone_author FOREIGN KEY (FK_Phone_Author) REFERENCES Author(author_id);

ALTER TABLE Author
ADD CONSTRAINT fk_author_email FOREIGN KEY (FK_Author_Email) REFERENCES Email(email_id);

ALTER TABLE Address
ADD CONSTRAINT fk_address_author FOREIGN KEY (FK_Address_Author) REFERENCES Author(author_id);

ALTER TABLE Ad
ADD CONSTRAINT fk_ad_heading FOREIGN KEY (FK_Ad_Heading) REFERENCES Heading(heading_id),
ADD CONSTRAINT fk_ad_author FOREIGN KEY (FK_Ad_Author) REFERENCES Author(author_id);

ALTER TABLE Matching_ad
ADD CONSTRAINT fk_matching_ad_author FOREIGN KEY (FK_Mad_Author) REFERENCES Author(author_id),
ADD CONSTRAINT fk_matching_ad_heading FOREIGN KEY (FK_Mad_Heading) REFERENCES Heading(heading_id);