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
INSERT INTO fit_market.commentaire (titre, contenu, image, note, id_utilisateur, id_produit)
VALUES
    ('Tapi Yoga','Excellent tapis de yoga, très confortable!', 'yoga_review_image.jpg', 5, 1, 1),
    ('Miam miam', 'Les barres sont délicieuses.', NULL, 4, 2, 2),
    ('Vive le sport','J''adore les cours en ligne, pratique et efficace!', 'online_fitness_review.jpg', 5, 3, 3);