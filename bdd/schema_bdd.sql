DROP SCHEMA `fit_market` ;
CREATE SCHEMA `fit_market` ;
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
    image VARCHAR(255),
    description_produit TEXT
);
CREATE TABLE fit_market.cours (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    video VARCHAR(255),
    description_produit TEXT,
    jours_heures VARCHAR(255),
    duree INT,
    adresse VARCHAR(255),
    id_produit INT,
    FOREIGN KEY (id_produit) REFERENCES produit(id)
);
CREATE TABLE fit_market.commentaire (
    id INT AUTO_INCREMENT PRIMARY KEY,
    contenu TEXT NOT NULL,
    date_heure DATETIME DEFAULT CURRENT_TIMESTAMP,
    image VARCHAR(255),
    note INT CHECK (note >= 0 AND note <= 5),
    id_utilisateur INT,
    id_produit INT,
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id),
    FOREIGN KEY (id_produit) REFERENCES produit(id)
);

-- Ajout d'utilisateurs
INSERT INTO fit_market.utilisateur (nom, prenom,email, mot_de_passe)
VALUES
    ('Doe', 'John', 'john.doe@email.com', 'motdepasse123'),
    ('Smith', 'Alice', 'alice.smith@email.com', 'password456'),
    ('Johnson', 'Bob', 'bob.johnson@email.com', 'securepass789');

-- Ajout de produits
INSERT INTO fit_market.produit (nom, prix, image, description_produit)
VALUES
    ('Tapis de yoga', 29.99, 'tapis_yoga.jpg', 'Tapis de yoga antidérapant et confortable'),
    ('Fit protein bar', 15.99, 'fit_protein_bar.jpg', 'Ensemble de 6 bar de protein'),
    ('Cours de yoga', 19.99, 'cours_yoga.jpg', 'Programme de 1h de cours de yoga pour la relaxation et la flexibilité');

-- Ajout de cours
INSERT INTO fit_market.cours (nom, video, description_produit, jours_heures, duree, adresse, id_produit)
VALUES
    ('Yoga Relaxant', 'yoga_relax_video.mp4', 'Cours de yoga pour la relaxation et la flexibilité', 'Lundi 18h-19h, Mercredi 19h-20h', 60, '123 Rue du Yoga, Ville', 3);

-- Ajout de commentaires
INSERT INTO fit_market.commentaire (contenu, image, note, id_utilisateur, id_produit)
VALUES
    ('Excellent tapis de yoga, très confortable!', 'yoga_review_image.jpg', 5, 1, 1),
    ('Les barres sont délicieuses.', NULL, 4, 2, 2),
    ('J''adore les cours en ligne, pratique et efficace!', 'online_fitness_review.jpg', 5, 3, 3);