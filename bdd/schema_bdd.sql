-- Suppression du schéma existant
DROP SCHEMA IF EXISTS `fit_market`;
CREATE SCHEMA `fit_market`;

-- Création des tables
CREATE TABLE fit_market.utilisateur (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    mot_de_passe VARCHAR(255) NOT NULL
);

CREATE TABLE fit_market.produit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prix DECIMAL(10, 2) NOT NULL,
    description_produit TEXT
);

CREATE TABLE fit_market.image_produit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_produit INT,
    image VARCHAR(255),
    FOREIGN KEY (id_produit) REFERENCES produit(id)
);

CREATE TABLE fit_market.cours (
    id INT AUTO_INCREMENT PRIMARY KEY,
    video VARCHAR(255),
    jours_heures VARCHAR(255),
    duree INT,
    adresse VARCHAR(255),
    id_produit INT,
    FOREIGN KEY (id_produit) REFERENCES produit(id)
);

CREATE TABLE fit_market.commentaire (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(100) NOT NULL,
    contenu TEXT NOT NULL,
    date_heure DATETIME DEFAULT CURRENT_TIMESTAMP,
    note INT CHECK (note >= 0 AND note <= 5),
    id_utilisateur INT,
    id_produit INT,
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id),
    FOREIGN KEY (id_produit) REFERENCES produit(id)
);

CREATE TABLE fit_market.image_commentaire (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_commentaire INT,
    image VARCHAR(255),
    FOREIGN KEY (id_commentaire) REFERENCES commentaire(id)
);

CREATE TABLE fit_market.commande (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_utilisateur INT,
    date_commande DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id)
);

CREATE TABLE fit_market.commande_produit (
    id_commande INT,
    id_produit INT,
    quantite INT,
    PRIMARY KEY (id_commande, id_produit),
    FOREIGN KEY (id_commande) REFERENCES commande(id),
    FOREIGN KEY (id_produit) REFERENCES produit(id)
);
