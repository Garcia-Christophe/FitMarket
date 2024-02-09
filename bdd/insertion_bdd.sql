-- Suppression du contenu des tables
SET foreign_key_checks = 0;
TRUNCATE fit_market.image_commentaire;
TRUNCATE fit_market.commentaire;
TRUNCATE fit_market.commande_produit;
TRUNCATE fit_market.commande;
TRUNCATE fit_market.cours;
TRUNCATE fit_market.image_produit;
TRUNCATE fit_market.produit;
TRUNCATE fit_market.utilisateur;
SET foreign_key_checks = 1;

-- Ajout d'utilisateurs
INSERT INTO fit_market.utilisateur (nom, prenom, email, mot_de_passe)
VALUES
    ('Smith', 'John', 'john.smith@email.com', 'motdepasse1'),
    ('Doe', 'Alice', 'alice.doe@email.com', 'motdepasse1'),
    ('Johnson', 'Bob', 'bob.johnson@email.com', 'motdepasse1'),
    ('Dupont', 'Marie', 'marie.dupont@email.com', 'motdepasse1'),
    ('Martin', 'Nicolas', 'nicolas.martin@email.com', 'motdepasse1'),
    ('Lefebvre', 'Sophie', 'sophie.lefebvre@email.com', 'motdepasse1'),
    ('Dubois', 'Thomas', 'thomas.dubois@email.com', 'motdepasse1');

-- Ajout de produits
INSERT INTO fit_market.produit (nom, prix, description_produit)
VALUES
    -- Matériels (10: eric flag)
    ('Banc de Musculation', 169.00, "Hauteur ajustable : Notre banc de musculation et son rouleau se règlent très rapidement à 7 différentes hauteurs (de 35 à 50 cm) en fonction de l'exercice souhaité et de votre morphologie.

Confort maximal : Il était essentiel pour nous de proposer un banc de musculation complet alliant confort et design. Ce banc de sport propose un coussin et une plateforme de forte épaisseur, rien de mieux pour réaliser des séances de musculation intenses et sans gêne !

Ultra-polyvalent : Vous pourrez effectuer une multitude d'exercices sur notre banc de musculation. Il est également possible de placer des bandes élastiques de part et d'autre du Power Bench grâce aux supports de fixation.

Voici quelques exemples d'exercices réalisables avec le banc de sport multi-fonctions : 

Hip Trust : Fessier
Crunch & Dragon Flag : Abdominaux
Nordic Ham Curls : Ischio-jambier & Fessier
Fentes Bulgares : Fessier & Quadriceps
Pompes : Pectoraux
Box Step Up : Fessier, Quadriceps & Ischio-jambiers
Tirage Bûcheron : Dos
Pistol Squat : Fessier & Quadriceps
Rowing avec Bandes Élastiques : Grand Dorsal
Charge maximale : 300 kg"),
    ('Gilet Lesté 10 & 20kg', 124.90, "Ajustable en quelques secondes : Adaptez facilement le gilet à votre morphologie en serrant la sangle d'ajustement. Le poids du gilet s'adapte facilement grâce aux incréments en acier fournis : profitez d'un maximum de polyvalence !

Ultra-compact : Nous avions à coeur de développer le gilet lesté le plus fit et compact du marché, et c'est chose faite ! Grâce aux 8 poids individuels de 1,2 kg fournis avec le gilet de 10kg (16 poids pour celui de 20kg), nous garantissons une coupe étroite et très près du corps afin de conserver une grande liberté de mouvement lors de vos séances de musculation, de Street Workout ou de Crossfit.

Possibilités infinies grâce au lest progressif : Performez dans toutes les disciplines en adaptant le lest à votre niveau d'entraînement et à vos objectifs. Progressez de nouveau, gagnez en force et en explosivité sur des exercices comme les dips, tractions, pompes, squats et toutes leurs variations. Nos gilets vous aideront à vous surpasser !"),
    ('Ceinture de Lest', 25.90, "Ultra-confortable & Durable : 
• Revêtement et coutures en Nylon de haute qualité pour une solidité maximale.
• La chaîne et la ceinture peuvent supporter jusqu'à 180 kg de charge !
• Dos large et rembourré pour un maximum de confort et d'adhérence.

Dimensions customisées de A à Z :
• Ceinture de lest de 76cm de longueur en matériau très souple, adaptée à toutes les morphologies !
• Une chaîne de taille optimisée de plus de 90 cm au total, permettant plus de liberté sur la hauteur. La charge pendra en fonction du point d'accroche du mousqueton.

Installation en quelques secondes : Mise en place rapide de la ceinture de lest grâce à 2 mousquetons seulement. Ne perdez pas de temps pendant votre séance de musculation ou de street workout ! 

Surpassez-vous ! Se lester reste le meilleur moyen de progresser dans les exercices au poids du corps comme les tractions, dips et squats, afin d'avoir un physique puissant et esthétique. La ceinture lestée ne lâchera certainement pas avant vous !"),
    ('Bandes Élastiques', 39.90, "Utilisées dans une multitude de sports et de disciplines différentes, les bandes élastiques sont les meilleures amies des adeptes de musculation au poids du corps. Les élastiques représentent souvent le premier investissement que nous conseillons et très certainement celui qui sera le plus rentable !

Chaque bande forme une boucle d'une longueur de 208 cm. Largeur de bandes de 13, 22 et 32 mm.

Bandes élastiques fabriquées en latex 100% naturel."),
    ('Kettlebell Ajustable 20kg', 119.90, "Ajustable en quelques secondes : Adaptez facilement le poids de votre kettlebell de 1,5 kg à 20 kg en fonction de votre séance !

Ultra-compact : Nous avions à coeur de développer un kettlebell compact afin qu'il soit adapté à tout type d'exercice en octroyant une grande liberté de mouvement ! Cela le rend également facile à transporter.

Deux poignées fournies : Grâce à nos poignées en 'D' et en 'T', les possibilités d'exercices sont décuplées rendant votre kettlebell ultra polyvalent !

Jusqu'à 150kg : Utilisez les poids fournis pour ajuster votre kettlebell jusqu'à 20kg, ou utilisez des disques olympiques jusqu'à 150kg !"),
    ('Parallettes en Bois', 44.90, "Préservez vos poignets ! Les parallettes en bois permettent de réaliser de nombreuses figures de Street Workout comme les pompes, le handstand, le L-sit ou la planche. Grâce à celles-ci, vos poignets seront dans le même axe que vos bras, ce qui améliore grandement l'équilibre tout en réduisant le stress sur les poignets. 

Dimensions optimales : Imaginées par Eric, nos parallettes bois ont été conçues pour être compactes, légères et facilement transportables :

• Hauteur : 10 cm
• Longueur utile de la barre : 30 cm
• Ø Diamètre de la barre : 4 cm

Pads antidérapants : Placés sous chaque pied, les pads antidérapants vous garantissent un maximum d'adhérence sur tous types de terrains et une stabilité optimale. Rien de pire que des barres parallèles qui glissent ou qui abîment votre sol en intérieur !

Fabriquées en bois de Hêtre : Le meilleur choix pour allier solidité, longévité et esthétisme."),
    ('Anneaux de Gymnastique', 44.90, "Anneaux gymnastique aux dimensions olympiques officielles : 2,8 cm d'épaisseur et 18 cm de diamètre intérieur pour nos anneaux en bois de bouleau lissé de très haute qualité offrant une excellente adhérence.

Des sangles sûres et optimales : 5,1 m de long et 3,8 cm de large pour une solidité et durabilité à toute épreuve permettant une charge de plus de 300 kg par anneau.

Une graduation précise des sangles grâce à un marquage permanent qui vous permettra d'ajuster rapidement la hauteur des sangles et de vous assurer que les deux anneaux sont à la même hauteur.

Des boucles en métal ultra-solides et faciles d'utilisation pour ajuster la hauteur en quelques secondes.

Plus de 60 exercices disponibles : Développez votre haut du corps grâce à une multitude d'exercices réalisables sur les anneaux de gymnastique !"),
    ('Magnésie Liquide', 13.90, "Pratique, propre et efficace : Notre magnésie liquide de 200 ml permet de conserver vos mains au sec pendant les séances intenses où la transpiration a tendance à les rendre moites et glissantes. Ne soyez plus limités par votre poigne pendant vos séances !

Formule économique : quelques gouttes de magnésie liquide suffisent pour chaque entraînement ou sport nécessitant d'avoir les mains sèches, chaque flacon pourra durer plusieurs mois.

Flacon spécialement conçu pour résister aux chutes et spécifiquement développé afin d'éviter l'obstruction du bouchon par accumulation de magnésie !

Approuvée par des sportifs de haut niveau : Notre magnésie liquide (ou craie liquide) bénéficie de propriétés anti-transpirantes pour éviter d'avoir les mains moites pendant vos séances de sport. Avoir un bon grip est indispensable dans un grand nombre de sports : street workout, crossfit, musculation, pole dance, gymnastique ou encore l'escalade. La magnésie liquide est conçue pour améliorer votre poigne tout au long de chacun de vos entraînements !"),
    ('Tapis de Sport', 31.90, "Dimensions optimales : Pour un confort accru, notre tapis de sport propose une épaisseur de 8 mm, supérieure à la moyenne des autres tapis. Il dispose d'une longueur de 181 cm et d'une largeur de 61 cm pour convenir à toutes et à tous.

Tapis de sol en TPE : Matière hautement qualitative afin de procurer une meilleure résistance et une grande durabilité au produit comparé aux tapis en mousse. Le TPE est 100% recyclable et non toxique.  

Waterproof : Vous pourrez le nettoyer ou le laver après votre séance de sport, yoga, gym ou encore de pilates.

Surface antidérapante : Le tapis restera au sol pendant vos séances afin d'optimiser vos mouvements !

Rangement facile : Notre tapis de fitness est facilement enroulable. Il dispose également d'une sangle pour le transporter lors d'une séance en salle de sport ou en extérieur."),
    ('Bouteille Isotherme', 19.90, "Le meilleur des formats : Bouteille isotherme d'une contenance de 750 ml afin d'avoir le bon volume de liquide lors de votre journée de travail, d'étude ou pendant votre séance de sport. Elle vous suivra partout !

Fabriquée en Acier inoxydable : Permet d'éviter les transferts de particules néfastes pour l'organisme (comme le BPA). Notre bouteille isotherme dispose également d'une double paroi permettant une isolation thermique entre le contenu de la bouteille et l'air extérieur. Cela vous permettra de garder votre boisson chaude ou froide tout au long de la journée.

Bouchon entièrement hermétique : Aucun risque de fuite de la gourde isotherme, vous serez protégé et le liquide restera à la bonne température. 

Durable et écologique : Fini les bouteilles en plastiques, faites dès à présent le meilleur choix pour votre santé et pour la planète ! Notre bouteille isotherme de haute qualité, conçue avec des matériaux premium, vous permettra de déguster vos boissons préférées (eau, thé, café, jus de fruits, shake protéiné, etc.) tout au long de chaque journée. 

Lavage et entretien : Pour garder un niveau maximal d'hygiène, nous vous conseillons de rincer votre bouteille isotherme à l'eau tiède après chaque utilisation ou avec de l'eau savonneuse dans le cas où la solution buvable est autre que de l'eau."),
    -- Nutrition (10)
    ('Crème protéinée au Chocolat', 9.98, "Du chocolat au petit-déjeuner ? Les pâtes à tartiner au chocolat vendues en supermarché contiennent beaucoup de sucre et d'huile de palme. Il en va tout autrement de la crème protéinée au chocolat nu3 :

• Pâte à tartiner protéinée avec 20 % de protéines issues de whey concentrée
• 85 % moins de sucre qu'une pâte à tartiner traditionnelle
• Végétarien, sans gluten, sans conservateurs
• Sans huile de palme ni aspartame
• Dispo en 3 saveurs : chocolat blanc, choco-noisette & caramel salé

Pour un début de journée sain et gourmand !"),
    ('Barre protéinée Fit', 7.99, "Fit Protein Bar : bien plus qu'une simple barre protéinée
Vous aimez les brownies au chocolat, la combinaison cacahuèetes-caramel ou chocolat blanc - framboise vous fait de l'oeil ? Alors vous allez adorer les Fit protein bars nu3. Voici de quoi vous convaincre :

• Au moins 32 % de protéines
• Maxiumum 202 kcal dans chaque barre
• Sans huile de palme, sucralose ni aspartame

Une véritable explosion de goût ! Découvrez la nouvelle génération de barres protéinées !"),
    ('Beurre de cacahuète', 7.99, "Beurre de cacahuète nu3 : bon pour le corps et l'âme
Vous vous demandez où acheter votre beurre de cacahuète ? Si vous n'avez pas encore goûté au peanut butter de la boutique nu3 France, vous passez à côté de quelque chose :

• Sans sucre ajouté, sans huile de palme et sans sel.
• Plus de 29 % de protéines végétales
• Incroyablement crémeux
• Véritable goût de cacahuète irrésistible
• A tartiner sur du pain, pour pâtisser ou à manger à la petite cuillère !

Ce sera sans aucun doute votre nouveau beurre de cacahuète préféré. C'est promis ! Envie d'un beurre de cacahuète crunchy avec morceaux ou plutôt d'une pate lisse ? Goûtez les deux pour vous décider."),
    ('Boeuf séché', 3.99, "Beef Jerky : snack protéiné salé à grignoter
Vous avez faim d'un snack salé et nourrissant, mais vous ne voyez aucun steak saignant à l'horizon ? Notre Beef Jerky est l'alternative parfaite aux barres protéinées sucrées. Il est hyper riche en protéines avec plus de 50 % de protéines et une faible teneur en graisses et en sucre. Il faut l'essayer : 

Viande de bœuf de haute qualité provenant d'Autriche
100% sans conservateurs artificiels ou exhausteurs de goût
Un minimum de 25,5 g de protéines par sachet 
Snack idéal pour un boost de protéines"),
    ('Fit Muffins protéinés', 7.59, "Fit Muffins protéinés - La parfaite alternative fitness
Vous adorez les muffins mais vous les trouvez trop sucrés ? Avec la préparation pour muffins protéinés nu3, vous pouvez préparer des muffins healthy, pauvres en sucre et riches en fibres. Ces mini-muffins riches en protéines sont faciles et rapides à réaliser. À peine mélangée, la pâte est prête à l'emploi et une odeur alléchante s'échappe déjà du four.

Muffins healthy chocolat ou citron - avec la préparation nu3, les muffins font désormais partie d'une alimentation fitness."),
    ("Purée d'amande bio", 10.99, "Quelle est la particularité de la purée d’amande bio nu3 ?
Sa pureté. En effet, la purée d'amandes complètes et la purée d'amandes blanches ne contiennent que des amandes bio. Celles-ci sont soigneusement sélectionnées, permettant d'obtenir un beurre d'amande onctueux de qualité, au goût d'amande douce, sans traitement chimique. Notre crème d'amandes bio garantit :

• Une méthode de transformation douce
• Un arôme harmonieux
• Un plaisir onctueux

La purée d'amande vous apporte des protéines végétales et des bonnes graisses, ce qui la rend idéale pour les régimes vegan et végétariens. Savourez-la sans modération."),
    ('Huile de coco bio', 19.58, "De la noix de coco pure - et rien d'autre
Notre huile de coco biologique nu3 est exclusivement produite à partir de la chair de la noix de coco fraîche et est travaillée avec soin. Elle conserve ainsi le goût exotique et fin de la noix de coco pure.

Notre huile de coco pure a encore plus à offrir :

Bonne pour vous et pour l'environnement : issue de l'agriculture biologique contrôlée
Teneur élevée en nutriments : dès la première pression à froid
Naturelle : non raffinée ni solidifée, ni blanchie ni désodorisée
Particulièrement résistante à la chaleur : idéale pour la cuisine
Substitut optimal au beurre : pour une alimentation végétalienne"),
    ("Farine d'amande bio", 17.99, "Farine d'amande bio : l'alternative à la farine de blé
Avec notre farine d'amande nu3, la pâtisserie sans gluten n'a jamais été aussi simple ! Mais qu'est-ce qui rend cette farine si particulière et à quoi faut-il faire attention lors de l'utilisation ? Découvrez ici tout ce qu'il faut savoir sur la farine d'amande bio nu3 !

Notre garantie :

• Farine d'amandes bio 100 % naturelle provenant d'Espagne/Italie.
• Bonnne pour vous et pour l'environnement : les amandes proviennent de cultures biologiques contrôlées
• La farine est riche en fibres et fournit plus de 50 % de protéines : une alternative parfaite à la farine traditionnelle.
• Contient environ 90 % de glucides en moins que la farine de blé* et est donc idéale pour une alimentation low carb.
• Polyvalente - grâce à son goût légèrement sucré, elle rehausse vos recettes préférées."),
    ('Purée de noix de cajou bio', 9.29, "100% purée de noix de cajou - et rien d'autre
Notre purée de noix de cajou ne contient rien d'autre que des noix de cajou naturelles. Celles-ci sont délicatement moulues en France puis mises en bocaux. Leur particularité : leur transformation s'effectue à basse température inférieure à 42°C. Ainsi, les précieux nutriments sont conservés de façon optimale."),
    ('Herbesan Thé brûle-graisse bio', 3.99, "Une tisane délicieuse aux plantes !

- L'arôme naturel d'ananas rend cette tisane brûle-graisse savoureuse pour un moment de bien-être
- Formule minceur à base de maté vert, thé vert et guarana
- Ingrédients issus de l'agriculture biologique"),
    -- Vêtements (10)
    ('Tee-shirt Power - Homme', 40, "EN QUÊTE DE FORCE
La nouvelle collection Power vous accompagne dans votre quête de force avec des designs oversize inspirés de la carrure des bodybuilders. Coupés dans des matériaux résistants aux coloris délavés, ces designs signés Power vous offriront le confort attendu en salle de sport comme en ville.
- Coupe oversize
- Matériau résistant
- Épaules basses
- Marque Gymshark imprimée en grand au dos
- 100% Coton
- 220gsm - Tissu lourd
- Le premier modèle mesure 175 cm et porte une taille L
- Le deuxième modèle mesure 183 cm et porte une taille M
- SKU: A2A9H-BBBB"),
    ('Tee-shirt Arrival Marl - Homme', 20, "REDÉFINISSEZ VOTRE POTENTIEL
Une collection qui existe pour vous permettre de réaliser tout votre potentiel. Arrival transforme vos entraînements en performances pleines de détermination. Réalisez un maximum de mouvements tout au long de votre entraînement grâce à son matériau léger, respirant et extensible.
- Coupe slim
- Matériaux légers
- Propriétés anti-sueur
- Ourlet droit
- Manches montées
- Col ras-du-cou
- Logo Gymshark thermoscellé sur le buste
- 100% Polyester
- Le modèle mesure 187 cm et porte une taille M
- SKU : A2A1I-GBQG"),
    ('Short Arrival - Homme', 25, "REDÉFINISSEZ VOTRE POTENTIEL
Une collection qui existe pour vous permettre de réaliser tout ce dont vous êtes capable. Arrival transforme vos entraînements en performances pleines de détermination. Réalisez un maximum de mouvements tout au long de votre entraînement grâce à son matériau léger, respirant et extensible.
- Coupe slim
- Short tissé
- Entrejambe de 18 cm
- Matériau léger
- Propriété anti-sueur
- Ceinture à cordon ajustable
- Poches latérales ouvertes
- Logo Gymshark imprimé sur la cuisse
- 100% Polyester
- Le modèle mesure 177 cm et porte une taille S
- SKU: A2A1L-BBBB"),
    ('Jogging Crest - Homme', 40, "POSEZ-VOUS EN CREST

En déplacement ou tranquille sur le canap', le style casual et confortable de la collection Crest est à porter partout et avec tout. Ses designs sont incroyablement doux et souples pour que vous puissiez combiner loisir et détente.

- Coupe slim
- Ceinture à cordon ajustable
- Poches latérales ouvertes et poche arrière à pression
- Manchons côtelés
- Logo Gymshark cousu et durable
- Tissu interne gratté et doux
- 80% Coton, 20% Polyester
- Le modèle mesure 180 cm et porte une taille S
- SKU : A2A4H-BBBB"),
    ('Chaussettes Crew 3PK - Homme', 14, "UN PORT FACILE, DES PERFORMANCE AISÉES.

Déambulez avec confort et style dans nos chaussettes Crew, du tapis de course au trottoir.

• Tricot éponge aux talon et orteils pour un meilleur amortissement et confort
• Coupe flatteuse au mollet
• Côtelure de la mi-pied au mollet
• 3 paires par paquet

TAILLE ET COUPE
• Chaussettes mi-mollet
• Petit : EUR 35-38. Medium: EUR: 39-41. Large: EUR 42-44

MATIÈRES ET ENTRETIEN
• 69 % coton, 28 % nylon, 3 % élas

SKU : I3A3P-WB7Z"),
    ('Legging sans couture pour tous les jours - Femme', 40, "À VOTRE RYTHME

Découvrez les pièces clés de votre journée de repos dans la collection Rest Day, composée de modèles aussi pratiques à porter que votre journée est décontractée.

• Taille haute pour plus de confort
• Coupe sans couture

Remarque : La collection Everyday n'est pas conçue pour les soulèvements de poids lourds ou les entraînements de haute intensité. Pour plus de confort, la collection est fabriquée dans une matière légère et sans couture qui peut devenir transparente lorsqu'étirée.

TAILLE ET COUPE
• Ajustement au corps
• Le mannequin est 172 cm et porte la taille S

MATIÈRES ET ENTRETIEN
• 88 % Nylon, 12 % Élasthanne

SKU : B7A3L-BB2J"),
    ('Bretelles Tout-en-un - Femme', 50, "UN TRAINING EXTRA

On a rendu nos nouvelles collections d'essentiels encore plus extra pour votre training.

- Bretelles croisées sophistiquées au dos
- Tissu à la texture fondante
- Maintien optimal avec un soutien-gorge intégré doublé à rembourrage amovible

TAILLE & COUPE
- Coupe moulante
- Entrejambe 15 cm
- Le premier modèle mesure 167 cm et porte une taille S
- Le deuxième modèle mesure 172 cm et porte une taille XS

MATÉRIAUX & ENTRETIEN
- 78% Nylon, 22% Élasthanne
- SKU : B4A8R-BBBB"),
    ('Short Crossover - Femme', 38, "UN TRAINING EXTRA

On a rendu nos nouvelles collections d'essentiels encore plus extra en augmentant leur performance d'un cran pour votre training.

- Design croisé à la taille pour un style sophistiqué
- Texture fondante pour un confort ultime
TAILLE & COUPE
- Taille haute
- Entrejambe de 15 cm
- Le modèle mesure 172 cm et porte une taille S

MATÉRIAUX & ENTRETIEN
- 78% Nylon, 22% Élasthanne

SKU: B4A9A-BBBB"),
    ('Tee-shirt Oversize Training - Femme', 22, "DANS VOTRE CASIER

La collection Training c'est LA collection qui assure vos arrières quel que soit votre sport. Hyper polyvalente et variée, elle vous offre un large choix de designs classiques et de couleurs douces ou acidulées à mix-matcher selon vos envies et vos workout…

- Coupe Oversized
- Logo Gymshark cousu
- Col côtelé
- Logo à gauche de la poitrine
- 100% Coton
- Le modèle mesure 165 cm et porte une taille XS
- SKU : B1A7M-UBCY"),
    ('Tee-shirt Oversize Fraction', 30, "STYLE FRACTIONNÉ

Élevez vos basics Gymshark avec un style Graphic Fraction. Ces designs épurés affichent un graphisme fractionné original et facile à porter. Sans parler du confort et de la souplesse de ses matériaux qui vous suivent à la salle comme en ville !

- Coupe oversize
- Épaules basses
- Col rond
- Graphisme Gymshark sérigraphié au dos
- Logo au milieu du buste
- 100% Coton
- Côtelage : 95% Coton, 5% Élasthanne
- Le modèle mesure 167 cm et porte une taille S
- SKU : B3A6L-BBGR"),
    -- Cours (10)
    ('Perdre du ventre en 30 minutes !', 16.90, "Vous voulez transpirer, perdre du poids, brûler du gras à la maison sans aucun matériel, et tout ça en seulement 30 minutes ? Vous êtes sur la bonne vidéo !

C'est parti !"),
    ('Entraînement grosses cuisses !', 22.00, "Hello ! J'espère que vous allez bien. C'est parti pour une nouvelle séance, et pas des moindres puisque c'est la séance cuisses, le leg day ! Ce n'est pas ma préférée, mais c'est pas une raison, alors...

C'est parti !"),
    ('Muscler ses pectoraux à la maison sans matériel (débutant)', 5.00, "Coucou tout le monde, j'espère que vous allez bien. On va faire ensemble notre défi du jour des 50 pompes. Ce défi vous pouvez le faire 2-3 fois par semaine. Il n'y aura pas de chrono dans cette vidéo, alors je vous invite à mettre sur pause pour récupérer autant que vous avez besoin.

C'est parti !"),
    ('Entraînemant abdos à la salle !', 12.00, "Coucou, c'est Tibo et c'est un plaisir de vous parler aujourd'hui. C'est parti pour une séance abdos. Vous allez venir avec moi, alors...

C'est parti !"),
    ('Exercice de sport pour les Enfants ! (10 minutes à la maison sans matériel)', 8.00, "L'entraînemant du jour c'est 10 minutes de sport spécial enfant...

C'est parti !"),
    ("Perdre vos poignées d'amour en 12 minutes ! 🔥", 7.00, "Aujourd'hui c'est 12 minutes d'abdominaux pour avoir les abdos visibles, le ventre plat, un ventre gaîné, bref une machine de guerre.

C'est parti !"),
    ('10 exercices à faire chaque matin pour perdre du poids !', 5.50, "Faites ces 10 minutes d'exercices tous les matins ! 10 exercices différents, 10 minutes d'entraînement max, objectif : perte de gras, perte de poids.

C'est parti !"),
    ('Cardio 30min brpule-graisse complet à la maison !', 21.00, "Aujourd'hui c'est la séance numéro 1 de notre programme Cardio Extrême Maison Sans Matériel. Vous êtes prêts ?

C'est parti !"),
    ('Avoir des abdos rapidement en 6 minutes !', 4.90, "La séance du jour va durer 6 minutes, spécial abdos. Pas besoin de matériel, juste de votre tapis de sport et de votre motivation...

C'est parti !"),
    ('Pectoraux abdos entrainement 8 minutes à la maison !', 7.50, "Aujourd'hui je vais être direct. Vous voulez des gros pecs ? Vous voulez des abdos ? Vous êtes sur la bonne séance !

C'est parti !");

-- Ajout des images de produits
INSERT INTO fit_market.image_produit (id_produit, image)
VALUES
    -- Matériels
    (1, 'https://ericflag.com/cdn/shop/files/Bench1800x1800.jpg?v=1698311717'),
    (1, 'https://ericflag.com/cdn/shop/files/Bench1800x1800-9_f5d9c446-dcc2-419d-980d-d9c5c662f505.jpg?v=1704463282'),
    (1, 'https://ericflag.com/cdn/shop/files/Bench1800x1800-15.jpg?v=1704481666'),
    (1, 'https://ericflag.com/cdn/shop/files/Bench1800x1800-7_69ebd539-2e07-49cb-beb8-9c4964f053bb.jpg?v=1704481666'),
    (1, 'https://ericflag.com/cdn/shop/files/Bench1800x1800-12_6ffdd9bd-c016-4942-8f00-ff2bc34ae72f.jpg?v=1704481666'),
    (2, 'https://ericflag.com/cdn/shop/products/ERICFLAG-2022-401.jpg?v=1668763023'),
    (2, 'https://ericflag.com/cdn/shop/files/gilet-20-1800x-5_c45addc8-890a-4f2a-9d4f-06c332ce2169.jpg?v=1694007737'),
    (2, 'https://ericflag.com/cdn/shop/products/DSC4182.jpg?v=1694007737'),
    (2, 'https://ericflag.com/cdn/shop/products/gilet-10-1800x-6.jpg?v=1700669316'),
    (2, 'https://ericflag.com/cdn/shop/products/gilet-close-1800x-2.jpg?v=1700669316'),
    (3, 'https://ericflag.com/cdn/shop/products/ERICFLAG-2022-407_d0daecb7-6849-4866-813b-82333264784f.jpg?v=1668953510'),
    (3, 'https://ericflag.com/cdn/shop/files/kettle1800x1800-3_1daf0845-21e4-4b78-8a04-293cd1aba1f6.jpg?v=1700581038'),
    (3, 'https://ericflag.com/cdn/shop/files/ceinture1800x1800-6.jpg?v=1700581456'),
    (3, 'https://ericflag.com/cdn/shop/files/ceinture1800x1800-4.jpg?v=1700581456'),
    (3, 'https://ericflag.com/cdn/shop/files/ceinture1800x1800-5.jpg?v=1700581456'),
    (4, 'https://ericflag.com/cdn/shop/files/elastiques1800x1800.jpg?v=1698757709'),
    (4, 'https://ericflag.com/cdn/shop/products/elastiques-1800x-3.jpg?v=1700558398'),
    (4, 'https://ericflag.com/cdn/shop/products/elastiques-1800x.jpg?v=1700558398'),
    (4, 'https://ericflag.com/cdn/shop/products/elastiques-1800x-4.jpg?v=1700558398'),
    (4, 'https://ericflag.com/cdn/shop/files/accessoire1800x1800-6_c5be5a08-476a-47fd-adaa-30333b0ef430.jpg?v=1700558398'),
    (5, 'https://ericflag.com/cdn/shop/files/kettle1800x1800.jpg?v=1698312860'),
    (5, 'https://ericflag.com/cdn/shop/files/kettle1800x1800-2.jpg?v=1698928022'),
    (5, 'https://ericflag.com/cdn/shop/files/kettle1800x1800-11_0e8eb562-573b-4aa2-b10b-cce5f3dd3b98.jpg?v=1700328699'),
    (5, 'https://ericflag.com/cdn/shop/files/kettle1800x1800-14_cf965401-2b3f-45e4-bb7b-9eff8b16269b.jpg?v=1702652997'),
    (5, 'https://ericflag.com/cdn/shop/files/kettle1800x1800-10.jpg?v=1702652997'),
    (6, 'https://ericflag.com/cdn/shop/products/ERICFLAG-2022-419.jpg?v=1668777543'),
    (6, 'https://ericflag.com/cdn/shop/files/para-bois1800x1800.jpg?v=1700319131'),
    (6, 'https://ericflag.com/cdn/shop/products/para-1800x-2.jpg?v=1700319131'),
    (6, 'https://ericflag.com/cdn/shop/products/para-close-1800x.jpg?v=1700319120'),
    (6, 'https://ericflag.com/cdn/shop/products/Para-bois-1200x1200.jpg?v=1700319120'),
    (7, 'https://ericflag.com/cdn/shop/products/ERICFLAG-2022-477.jpg?v=1668762982'),
    (7, 'https://ericflag.com/cdn/shop/products/anneaux-1800x_ba76f3ac-408e-4cf0-b587-d3ba9be3df42.jpg?v=1699547298'),
    (7, 'https://ericflag.com/cdn/shop/products/anneaux-slide-1800x-2.jpg?v=1698691952'),
    (7, 'https://ericflag.com/cdn/shop/products/anneaux-1800x-3.jpg?v=1698691952'),
    (7, 'https://ericflag.com/cdn/shop/products/slide-anneaux-1800x.jpg?v=1698691952'),
    (8, 'https://ericflag.com/cdn/shop/products/ERICFLAG-2022-439.jpg?v=1668777260'),
    (8, 'https://ericflag.com/cdn/shop/files/magnesie-1800x1800.jpg?v=1700669164'),
    (8, 'https://ericflag.com/cdn/shop/products/magnesie-1800x-2.jpg?v=1700669390'),
    (8, 'https://ericflag.com/cdn/shop/products/magnesie-1800x-4.jpg?v=1700669390'),
    (8, 'https://ericflag.com/cdn/shop/files/Levitate1800x1800-4.jpg?v=1700669390'),
    (9, 'https://ericflag.com/cdn/shop/products/ERICFLAG-2022-384.jpg?v=1668777961'),
    (9, 'https://ericflag.com/cdn/shop/files/tapis1800x1800.jpg?v=1698676139'),
    (9, 'https://ericflag.com/cdn/shop/products/tapis-1800x-2.jpg?v=1698676139'),
    (9, 'https://ericflag.com/cdn/shop/files/tapis1800x1800-2.jpg?v=1698676139'),
    (9, 'https://ericflag.com/cdn/shop/products/tapis-1800x-3.jpg?v=1698676128'),
    (10, 'https://ericflag.com/cdn/shop/products/ERICFLAG-2022-444_47aebcc3-86b3-4570-9207-108adfab4af7.jpg?v=1672754658'),
    (10, 'https://ericflag.com/cdn/shop/products/bouteille-close-1800x-3.jpg?v=1700329329'),
    (10, 'https://ericflag.com/cdn/shop/files/bouteille-1800x1800.jpg?v=1700329329'),
    (10, 'https://ericflag.com/cdn/shop/products/bouteille-isotherme-141940.jpg?v=1700329329'),
    (10, 'https://ericflag.com/cdn/shop/products/bouteille-isotherme-206192.jpg?v=1700329329'),
    -- Nutrition
    (11, 'https://www.nu3.fr/cdn/shop/products/60eeb73a132ae131e27d5440ff982eb224605b84_21589_480x.jpg?v=1706003075'),
    (11, 'https://www.nu3.fr/cdn/shop/products/47b7afb2e0568f7ada6281f071f9bd5c6c836a8c_pdp_karussell_20869_mood_1_800x800_b5791a10-486f-4e7a-b57c-4c78d1ab7c1a_480x.jpg?v=1697013441'),
    (11, 'https://www.nu3.fr/cdn/shop/files/2600ad7d08b7923de94098931adecd69bfc41159_Protein_Cream_mood_480x.jpg?v=1697013445'),
    (12, 'https://www.nu3.fr/cdn/shop/products/39be8f590d5ba1ba4bf6fe136ec47ab162c09921_pdp_karussell_20865_mood_2_800x800_36e38c9d-d8f3-4a88-bdaf-12e282524443_480x.jpg?v=1681979660'),
    (12, 'https://www.nu3.fr/cdn/shop/products/2_252F6_252Fb_252F4_252F26b4784ad7bac35c57a4acbfbce327be78a70cab_nu3_fit_protein_bar_new2020_f37aa843-a56f-4116-a65c-83475f206418_480x.jpg?v=1698154938'),
    (12, 'https://www.nu3.fr/cdn/shop/files/5150e83efd29124a4e1fafb5089a9c35a46bcdb8_22333_480x.jpg?v=1698154942'),
    (13, 'https://www.nu3.fr/cdn/shop/products/3_252F9_252F0_252F4_252F3904f92197b248196a34c106a4c8b8011bf94cd9_20847_Top_480x.jpg?v=1694153009'),
    (13, 'https://www.nu3.fr/cdn/shop/products/f_252F5_252F4_252Fa_252Ff54a7d73dbfa6cdf013db4e88121b175dd048822_nu3_peanut_butter_5f5b9e5f-ec3c-4b90-b904-9cffe847cb44_480x.jpg?v=1702916858'),
    (13, 'https://www.nu3.fr/cdn/shop/products/6d8699215e24a32eaa3516b2b2ab60bcb442249f_pdp_karussell_20847_mood_2_800x800_a59b4260-d91b-4201-9929-60c03096719b_480x.jpg?v=1702626464'),
    (14, 'https://www.nu3.fr/cdn/shop/products/3_252F2_252Fc_252F3_252F32c38c5b2b39b4c99a0812b8c9eb2b0bc66be7a4_18939_480x.jpg?v=1702979849'),
    (14, 'https://www.nu3.fr/cdn/shop/products/7_252Ff_252Fa_252Fe_252F7fae67ec36afaec18fd5cc3b6c5e163a5c295691_nu3_beef_jerky_480x.jpg?v=1687876963'),
    (14, 'https://www.nu3.fr/cdn/shop/products/a056f4b30d64d58006b8cc946376cc06ddc670e2_pdp_karussell_15390_mood_1_800x800_0988c7de-33ad-4437-a39f-20a92fc18e39_480x.jpg?v=1700812033'),
    (15, 'https://www.nu3.fr/cdn/shop/products/b_252Fc_252F7_252F5_252Fbc755d1db637f431ba3ab771698f30f1d9b9a388_19507_Front_480x.jpg?v=1694153000'),
    (15, 'https://www.nu3.fr/cdn/shop/products/7a0acc3f3fe69a585c7cd7b53650234139ee6530_fit_muffins_rolemodel_480x.jpg?v=1694153000'),
    (15, 'https://www.nu3.fr/cdn/shop/products/f0cf734ac3a593958c43da5362a440b20d30de55_cupcakes_480x.jpg?v=1681821498'),
    (16, 'https://www.nu3.fr/cdn/shop/products/e_252F6_252Fc_252Fe_252Fe6ce5071b73b3232745b97a92905dd20d6d104d5_20393_simu_top_480x.jpg?v=1681974302'),
    (16, 'https://www.nu3.fr/cdn/shop/products/7_252F7_252F5_252F4_252F7754cb5115578b4d18bab98f2c92bb1a3845f28e_product_model_17_480x.jpg?v=1681974302'),
    (16, 'https://www.nu3.fr/cdn/shop/products/8b02fdedd9cd0bfa26c189bff08f4835295f0528_mandelmus_480x.jpg?v=1689080238'),
    (17, 'https://www.nu3.fr/cdn/shop/products/76f53dd0d7c270c48a8c0bc2c571e48614b9dd91_22037_for_free_480x.jpg?v=1681798025'),
    (17, 'https://www.nu3.fr/cdn/shop/products/a_252F0_252F6_252F0_252Fa060bad411471d7e2a5321047e1438473a0fa920_20390_480x.jpg?v=1681797841'),
    (17, 'https://www.nu3.fr/cdn/shop/products/e4823346ca07f125890aec7e6548615e9f121d1c_pdp_karussell_8597_mood_800x800_a30494f4-bbf3-4982-9ce1-7d1c6f4c4035_480x.jpg?v=1681797809'),
    (18, 'https://www.nu3.fr/cdn/shop/files/27a6bea2b9f283bf42ff2fbeb75a554d96360f20_22238_switch_480x.jpg?v=1704724344'),
    (18, 'https://www.nu3.fr/cdn/shop/files/edb39ee2670233f7300b2b8a9996e71d64760ddd_22238_simu_480x.jpg?v=1704724346'),
    (19, 'https://www.nu3.fr/cdn/shop/products/0_252F4_252F5_252F3_252F0453324bed7d39c6f65cbf9c1a9d9c7e510a1550_17226_480x.jpg?v=1681973788'),
    (20, 'https://www.nu3.fr/cdn/shop/products/4c706cf714e035de1caf72e3d5f7985efe0076cd_11888_480x.jpg?v=1682513267'),
    -- Vêtements
    (21, 'https://cdn.shopify.com/s/files/1/2216/7835/files/PowerWordmarkSsT-ShirtBlackA2A9H-BBBB0044_a935b5fd-d518-4c98-8ece-820a99d8fcd0.jpg?v=1704289237'),
    (21, 'https://cdn.shopify.com/s/files/1/2216/7835/files/PowerWashedT-ShirtBlackA2A9H-BBBB-0428.jpg?v=1704289237'),
    (21, 'https://cdn.shopify.com/s/files/1/2216/7835/files/PowerWordmarkSsT-ShirtBlackA2A9H-BBBB0053_738ace5a-499f-427e-ac67-ed286dc69d11.jpg?v=1704272570'),
    (22, 'https://cdn.shopify.com/s/files/1/2216/7835/products/ArrivalSlimMarlSST-Shirt-SilhouetteGreyLightGreyMarlA2A1I-GBQG2.jpg?v=1665061392'),
    (22, 'https://cdn.shopify.com/s/files/1/2216/7835/products/ArrivalSlimMarlSST-Shirt-SilhouetteGreyLightGreyMarlA2A1I-GBQG16.jpg?v=1665061392'),
    (22, 'https://cdn.shopify.com/s/files/1/2216/7835/products/ArrivalSlimMarlSST-Shirt-SilhouetteGreyLightGreyMarlA2A1I-GBQG20.jpg?v=1665061392'),
    (23, 'https://cdn.shopify.com/s/files/1/2216/7835/products/ARRIVALSHORTSBLACKA2A1L-BBBBANDA2A1L-BBBB.A.jpg?v=1684493900'),
    (23, 'https://cdn.shopify.com/s/files/1/2216/7835/products/ARRIVALSHORTSBLACKA2A1L-BBBBANDA2A1L-BBBB.B.jpg?v=1684493900'),
    (23, 'https://cdn.shopify.com/s/files/1/2216/7835/products/ARRIVALSHORTSBLACKA2A1L-BBBBANDA2A1L-BBBB.C.jpg?v=1684493900'),
    (24, 'https://cdn.shopify.com/s/files/1/2216/7835/files/CREST_JOGGER_-_BLACK.A-Edit_ZH_1_ce797cb6-2232-4dcf-85cd-9ac095998071.jpg?v=1705436528'),
    (24, 'https://cdn.shopify.com/s/files/1/2216/7835/files/CREST_JOGGER_-_BLACK.B-Edit_ZH_a3e4662d-a4de-49b2-b270-96f09807347e.jpg?v=1705436529'),
    (24, 'https://cdn.shopify.com/s/files/1/2216/7835/files/CREST_JOGGER_-_BLACK.D1-Edit_ZH_593228a7-1f09-43b9-845c-62561671dd54.jpg?v=1705436530'),
    (25, 'https://cdn.shopify.com/s/files/1/2216/7835/files/CrewSocks3pk-GSWhite-LightGreyCoreMarl-GSBlack-I3A3P-WB7Z1.jpg?v=1693322960'),
    (25, 'https://cdn.shopify.com/s/files/1/2216/7835/files/CrewSocks3pkGSWhite-LightGreyCoreMarl-GSBlack-I3A3P-WB7Z-0450_21e40cfe-a304-4ccb-a038-0a3a73b5eb62.jpg?v=1693322960'),
    (26, 'https://cdn.shopify.com/s/files/1/2216/7835/files/EverydaySeamlessLeggingsGSBlackB7A3L-BB2J-1661_777f3021-4acc-4f61-8412-5b0738e291fc.jpg?v=1690107789'),
    (26, 'https://cdn.shopify.com/s/files/1/2216/7835/files/EverydaySeamlessLeggingsGSBlackB7A3L-BB2J-1674_2b442f3f-86fb-4294-99fa-89dfa47a74fc.jpg?v=1690107789'),
    (26, 'https://cdn.shopify.com/s/files/1/2216/7835/files/EverydaySeamlessLeggingsGSBlackB7A3L-BB2J-1670_a56d28cc-6599-4de4-8e49-21686fccd6a8.jpg?v=1690107789'),
    (27, 'https://cdn.shopify.com/s/files/1/2216/7835/files/IconTrendAllInOneBlack-B4A8R-BBBB-2320.262-Edit_794592dc-6ae3-430e-b948-09a78371a7e5.jpg?v=1701441745'),
    (27, 'https://cdn.shopify.com/s/files/1/2216/7835/files/IconTrendAllInOneBlack-B4A8R-BBBB-2340.264-Edit_e9dcb2a4-fc4b-4743-9ea8-19d13cbb9f8b.jpg?v=1701441745'),
    (27, 'https://cdn.shopify.com/s/files/1/2216/7835/files/IconTrendAllInOneBlack-B4A8R-BBBB-2342.265-Edit_a2ebb0ba-0817-49a8-99bd-3fa65e62b771.jpg?v=1701441745'),
    (28, 'https://cdn.shopify.com/s/files/1/2216/7835/files/IconTrendShortsBlackB4A9A-BBBB.82_d5c83eaf-fc36-4dd0-85c7-294ef1cabb25.jpg?v=1704900881'),
    (28, 'https://cdn.shopify.com/s/files/1/2216/7835/files/IconTrendShortsBlack-B4A9A-BBBB-2256.68-Edit_ecac84ed-0a49-4a9a-90b9-2602b5ec7986.jpg?v=1704900881'),
    (28, 'https://cdn.shopify.com/s/files/1/2216/7835/files/IconTrendShortsBlack-B4A9A-BBBB-2274.70-Edit_f9b3e935-3071-4eed-ac70-8ed044727cf1.jpg?v=1704900881'),
    (29, 'https://cdn.shopify.com/s/files/1/2216/7835/products/TRAININGOVERSIZEDT-SHIRT-RosewoodRedB1A7M-RBHH4_88ba62e5-7e53-4143-ac3e-d040fc59fb39.jpg?v=1677503894'),
    (29, 'https://cdn.shopify.com/s/files/1/2216/7835/products/TRAININGOVERSIZEDT-SHIRT-RosewoodRedB1A7M-RBHH13_f4aeaa32-ef0a-460c-82a6-51f9d4dc6955.jpg?v=1677503894'),
    (29, 'https://cdn.shopify.com/s/files/1/2216/7835/products/TRAININGOVERSIZEDT-SHIRT-RosewoodRedB1A7M-RBHH14_2ddd49e2-857a-4fac-83f8-db1d215a8179.jpg?v=1677503894'),
    (30, 'https://cdn.shopify.com/s/files/1/2216/7835/products/GRAPHICSFRACTIONOVERSIZEDT-SHIRT-Black_WhiteB3A6L-BBGR.jpg?v=1663658984'),
    (30, 'https://cdn.shopify.com/s/files/1/2216/7835/products/GRAPHICSFRACTIONOVERSIZEDT-SHIRT-Black-White-B3A6L-BBGR.A_da957273-925c-4108-a48b-17e301d517df.jpg?v=1663658984'),
    (30, 'https://cdn.shopify.com/s/files/1/2216/7835/products/GRAPHICSFRACTIONOVERSIZEDT-SHIRT-Black-White-B3A6L-BBGR.C_5535a8e8-0c6c-4405-95ce-00f1c146c42c.jpg?v=1663658984'),
    -- Cours
    (21, 'https://i3.ytimg.com/vi/vftQ8xvlSic/maxresdefault.jpg'),
    (22, 'https://i3.ytimg.com/vi/9XN-_UIo9tM/maxresdefault.jpg'),
    (23, 'https://i3.ytimg.com/vi/oHETiT6kXaA/maxresdefault.jpg'),
    (24, 'https://i3.ytimg.com/vi/w_LnxNJuxJI/maxresdefault.jpg'),
    (25, 'https://i3.ytimg.com/vi/lugeXEY2vYI/maxresdefault.jpg'),
    (26, 'https://i3.ytimg.com/vi/rniSf3BDef0/maxresdefault.jpg'),
    (27, 'https://i3.ytimg.com/vi/WCrjyTaP0Pc/maxresdefault.jpg'),
    (28, 'https://i3.ytimg.com/vi/U3HueZj9wU0/maxresdefault.jpg'),
    (29, 'https://i3.ytimg.com/vi/gZph6ng7QXE/maxresdefault.jpg'),
    (30, 'https://i3.ytimg.com/vi/Rn-iTuIaRNs/maxresdefault.jpg');

-- Ajout de cours
INSERT INTO fit_market.cours (video, jours_heures, duree, adresse, id_produit)
VALUES
    ('https://www.youtube.com/watch?v=vftQ8xvlSic', 'Lundi 18h-19h, Mercredi 19h-20h', 32, 'Fitness Park - 15 Rue Eugène Freyssinet, 94000 Créteil', 31),
    ('https://www.youtube.com/watch?v=9XN-_UIo9tM', 'Lundi/Mercredi 20h30-21h30', 45, 'CMG Sports Club - 3 Rue de Bucarest, 75008 Paris', 32),
    ('https://www.youtube.com/watch?v=oHETiT6kXaA', 'Mardi/Jeudi 17h30-18h30', 8, 'Basic-Fit - 2 Rue du Général de Gaulle, 94350 Villiers-sur-Marne', 33),
    ('https://www.youtube.com/watch?v=w_LnxNJuxJI', 'Mercredi/Vendredi/Samedi 19h30-20h30', 20, 'Keep Cool - 23 Avenue des Prés, 78180 Montigny-le-Bretonneux', 34),
    ('https://www.youtube.com/watch?v=lugeXEY2vYI', 'Lundi 18h00-19h00', 11, 'Neoness - 32 Rue de la Chapelle, 75018 Paris', 35),
    ('https://www.youtube.com/watch?v=rniSf3BDef0', 'Samedi 10h00-11h00, 16h00-17h00', 13, 'Amazonia - 22 Avenue Paul Vaillant Couturier, 94400 Vitry-sur-Seine', 36),
    ('https://www.youtube.com/watch?v=WCrjyTaP0Pc', 'Dimanche 10h00-11h00, 18h00-19h00', 11, "Fitlane - 31 Avenue de l'Europe, 77184 Émerainville", 37),
    ('https://www.youtube.com/watch?v=U3HueZj9wU0', 'Lundi 20h30-21h30', 31, "L'Appart Fitness - 5 Rue Jules Vallès, 75011 Paris", 38),
    ('https://www.youtube.com/watch?v=gZph6ng7QXE', 'Mardi 17h30-18h30, 19h30-20h30', 8, 'Le Club Moving - 4 Rue de la Préfecture, 06300 Nice', 39),
    ('https://www.youtube.com/watch?v=Rn-iTuIaRNs', 'Mercredi 14h00-15h00, 19h30-20h30, 21h00-22h00', 11, 'Orange Bleue - 5 Rue Michel Servet, 69100 Villeurbanne', 40);

-- Ajout de commandes
INSERT INTO fit_market.commande (id_utilisateur, date_commande)
VALUES
    (1, '20241201'),
    (1, '20240502'),
    (1, NULL);

-- Ajout de produits dans les commandes
INSERT INTO fit_market.commande_produit (id_commande, id_produit, quantite)
VALUES
    (1, 31, 1),
    (2, 3, 1),
    (2, 21, 3),
    (3, 15, 5);

-- Ajout de commentaires
INSERT INTO fit_market.commentaire (titre, contenu, date_heure, note, id_utilisateur, id_produit)
VALUES
    -- Matériel > Ceinture de lest
    ("Une histoire d'amour... Tout bonnement", "Les formes de cette ceinture épousent parfaitement le bas de mon dos. Je me sens supporté et encouragé à l'effort de haut en bas dans mes répétitions. Ca faisait longtemps que je n'avais pas pris autant de plaisir à pratiquer une activité sportive. Je recommande à 169 % !", "2023-12-01 12:54:02", 5, 1, 3),
    ("Matériaux très qualitatifs", "Matériaux très qualitatifs et ceinture fonctionnelle. Testée en traction et dips, très bonne expérience (moins de24 heures, mais je suis jusqu'à présent très satisfait du produit).", "2023-11-29 13:25:28", 5, 2, 1),
    ("Une bonne ceinture pour des gros PR", "J'avais déjà eu l'occasion de tester cette ceinture grâce à un ami et je l'avais adorée. Je l'ai donc commandée à mon tour pour qu'elle puisse m'accompagner dans ma recherche de performance sur les dips et tractions lestées.
Attention, elle tire un peu au niveau du bas du dos lorsqu'on commence à mettre une grosse charge !", "2023-10-07 18:17:19", 3, 3, 1),
    ("Ceinture de lest, au top", "La ceinture inspire confiance. Bien longue et large, très confortable.
La chaine fournit est assez longue et est solide
Les 2 mousquetons mettent en confiance.
Très satisfait de mon achat donc ! Merci team FitMarket", "2023-12-14 19:43:01", 4, 4, 1),
    -- Nutrition > Crème protéinée au Chocolat
    ("Service client exceptionnel", "Service client exceptionnel ! J'avais un soucis avec ma crème protéinée (défaut de production au niveau du couvercle). J'ai contacté le service client et j'ai pu avoir un nouveau pot sans le moindre inconvénient, ce qui m'a permis du coup de réutiliser ma slide bar, me faire économiser de l'argent et de moins polluer finalement !", "2023-12-10 08:28:42", 5, 5, 11),
    ("Produit très bien", "Si on abuse pas sur la quantité le goût est bon, pas écoeurant. Je suis contente, parfait pour tartine ou barre céréale maison.
Une étoile en moins pour la livraison, carton arrivé dans un état lamentable, limite ouvert, l'autre produit commandé avec abîmé et ceux-ci par miracle intacte.", "2023-11-21 10:30:12", 4, 6, 11),
    ("Vraiment très bon", "Le goût peut être surprenant au première abord mais c'est vraiment très bon, j'ai pris noisette et chocolat blanc et j'ai une petite préférence pour la noisette 😌", "2024-01-17 15:08:43", 4, 7, 11),
    -- Vêtements > Tee-shirt Power - Homme
    ("Très bonne qualité", "Livré en temps et en heures, rien à dire, bonne qualité. Et pour ceux qui pensent que le tee-shirt taille vraiment grand, je confirme ! Vous allez adorer ce tee-shirt vraiment ample. Bon... Pour le moment, c'est ma copine qui en profite !!! Lol. Merci à FitMarket et son équipe pour la qualité, la motivation et la simplicité des tutos pour le sport. Bonne continuation", "2024-01-12 15:49:25", 5, 1, 21),
    ("Matière vraiment agréable", "J'adore le tissu utilisé pour ce tee-shirt. Par contre je confirme ce que dit un autre commentaire : il taille grand ! N'hésitez pas à prendre une taille en-dessous si vous ne voulez pas nager dedans. J'ai été un peu surpris, mais mon enfant est content au final !", "2024-01-25 20:38:00", 4, 2, 21),
    -- Cours > Perdre du ventre en 30 minutes !
    ("On perd vraiment du ventre !!", "Déjà 10 minutes, tu sens tes abdos a la fin, alors 30... C'est pas donner a tout le monde, surtout ceux qui débutent. En tout cas, je continue tes exercices abdominaux et pectoraux, mon corps a changé grâce à toi! Merci.", "2024-02-05 22:22:58", 5, 1, 31),
    ("Je transpire comme il faut !", "Merci pour cette vidéo, ça devient compliqué vers la moitié, 41 ans et j'ai bien transpiré 😅, la douche va être appréciable. Parce que VOUS êtes les meilleurs ! Boooouuum 👍", "2024-02-05 22:22:58", 4, 5, 31);

-- Ajout des images de commentaires
INSERT INTO fit_market.image_commentaire (id_commentaire, image)
VALUES
    (1, "https://meilleurdusport.fr/wp-content/uploads/2022/08/meilleure-ceinture-de-lest-lestee-musculation-avis-comparatif-2.jpg"),
    (1, "https://homefittraining.fr/wp-content/uploads/2023/04/meilleures-ceintures-lestage-criteres-de-choix.jpg"),
    (1, "https://www.musculation-bras.fr/wp-content/uploads/2021/03/ceinture-lestee.gif"),
    (1, "https://m.media-amazon.com/images/I/81yO576EHLL._AC_UF1000,1000_QL80_.jpg"),
    (1, "https://spartan-homegym.fr/cdn/shop/products/NB56_0054-closeup_620x.jpg?v=1655474319"),
    (2, "https://cdn.shopify.com/s/files/1/0364/7792/7564/files/Ceintured_halterophilieavecchainedetrempage_600x600.jpg?v=1686611153"),
    (2, "https://www.gornation.com/cdn/shop/products/4ropefordilbeltweighteddips_1_288x.jpg?v=1704798288"),
    (4, "https://www.gornation.com/cdn/shop/files/dip-belt-up-to-1000kg_1200x.jpg?v=1695131338"),
    (5, "https://www.nu3.fr/cdn/shop/files/nu3_pdp_Vegan-Protein-Cream-Hazelnut-Cacao_600x300px-2-1_600x_a5361b4e-560c-4c58-aac5-e0a063e0f3c4_600x.webp?v=1704796270"),
    (5, "https://www.nu3.fr/cdn/shop/files/nu3_pdp_Vegan-Protein-Cream-Hazelnut-Cacao_600x300px-2_600x_69914429-a85e-4a94-96b2-4cb09a068972_600x.webp?v=1704796335"),
    (7, "https://www.nu3.at/cdn/shop/files/07cfa4a1d95af3a32ead7100d353ac7e4dad683f_nu3_pdp_Vegan_Protein_Cream_Hazelnut_Cacao_800x800px_2_620x620.jpg?v=1703673354"),
    (8, "https://cdn.shopify.com/s/files/1/2216/7835/products/PowerSsT-Shirt_Og_BlackA2A1W.BTIFF_IS.jpg?v=1660214419"),
    (8, "https://cdn.shopify.com/s/files/1/2216/7835/products/OversizedT-ShirtBlackA1A3E.A-Edit_BK_7d16b9bc-ec87-4935-bb82-ff50a4309582.jpg?v=1660214414"),
    (11, "https://www.mennenfrance.fr/-/media/jss-mennen/data/media/img/Blog/transpi-exces.ashx");