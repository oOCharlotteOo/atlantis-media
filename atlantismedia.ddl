-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 12 jan. 2020 à 10:37
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `atlantismedia`
--

-- --------------------------------------------------------

--
-- Structure de la table `artiste`
--

DROP TABLE IF EXISTS `artiste`;
CREATE TABLE IF NOT EXISTS `artiste` (
  `id_artiste` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_artiste`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `artiste_type_artiste`
--

DROP TABLE IF EXISTS `artiste_type_artiste`;
CREATE TABLE IF NOT EXISTS `artiste_type_artiste` (
  `id_artiste` int(11) NOT NULL,
  `id_type_artiste` int(11) NOT NULL,
  PRIMARY KEY (`id_artiste`,`id_type_artiste`),
  KEY `id_type_artiste` (`id_type_artiste`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id_categorie` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  PRIMARY KEY (`id_categorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `libelle`) VALUES
(1, 'Film'),
(2, 'Livre'),
(3, 'Musique'),
(4, 'Jeu Vidéo');

-- --------------------------------------------------------

--
-- Structure de la table `critique`
--

DROP TABLE IF EXISTS `critique`;
CREATE TABLE IF NOT EXISTS `critique` (
  `id_critique` int(11) NOT NULL,
  `commentaire` varchar(250) DEFAULT NULL,
  `note` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_critique`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `genre`
--

DROP TABLE IF EXISTS `genre`;
CREATE TABLE IF NOT EXISTS `genre` (
  `id_genre` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  PRIMARY KEY (`id_genre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `langue`
--

DROP TABLE IF EXISTS `langue`;
CREATE TABLE IF NOT EXISTS `langue` (
  `id_langue` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  PRIMARY KEY (`id_langue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `morceaux`
--

DROP TABLE IF EXISTS `morceaux`;
CREATE TABLE IF NOT EXISTS `morceaux` (
  `id_morceaux` int(11) NOT NULL,
  `titre_morceaux` varchar(50) NOT NULL,
  `duree` int(11) NOT NULL,
  PRIMARY KEY (`id_morceaux`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre`
--

DROP TABLE IF EXISTS `oeuvre`;
CREATE TABLE IF NOT EXISTS `oeuvre` (
  `id_oeuvre` int(11) NOT NULL,
  `titre` varchar(50) NOT NULL,
  `duree` int(11) DEFAULT NULL,
  `code_isbn` varchar(50) DEFAULT NULL,
  `date_acquisition` date DEFAULT NULL,
  `id_statut` int(11) NOT NULL,
  `id_origine` int(11) NOT NULL,
  `id_categorie` int(11) NOT NULL,
  `id_support` int(11) NOT NULL,
  PRIMARY KEY (`id_oeuvre`),
  KEY `id_categorie` (`id_categorie`),
  KEY `id_support` (`id_support`),
  KEY `id_origine` (`id_origine`),
  KEY `id_statut` (`id_statut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre_artiste`
--

DROP TABLE IF EXISTS `oeuvre_artiste`;
CREATE TABLE IF NOT EXISTS `oeuvre_artiste` (
  `id_oeuvre` int(11) NOT NULL,
  `id_artiste` int(11) NOT NULL,
  `date_de_realisation` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_oeuvre`,`id_artiste`),
  KEY `id_artiste` (`id_artiste`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre_critique`
--

DROP TABLE IF EXISTS `oeuvre_critique`;
CREATE TABLE IF NOT EXISTS `oeuvre_critique` (
  `id_oeuvre` int(11) NOT NULL,
  `id_critique` int(11) NOT NULL,
  `date_de_commentaire` date DEFAULT NULL,
  PRIMARY KEY (`id_oeuvre`,`id_critique`),
  KEY `id_critique` (`id_critique`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre_genre`
--

DROP TABLE IF EXISTS `oeuvre_genre`;
CREATE TABLE IF NOT EXISTS `oeuvre_genre` (
  `id_genre` int(11) NOT NULL,
  `id_oeuvre` int(11) NOT NULL,
  PRIMARY KEY (`id_genre`,`id_oeuvre`),
  KEY `id_oeuvre` (`id_oeuvre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre_langue`
--

DROP TABLE IF EXISTS `oeuvre_langue`;
CREATE TABLE IF NOT EXISTS `oeuvre_langue` (
  `id_oeuvre` int(11) NOT NULL,
  `id_langue` int(11) NOT NULL,
  PRIMARY KEY (`id_oeuvre`,`id_langue`),
  KEY `id_langue` (`id_langue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `oeuvre_morceaux`
--

DROP TABLE IF EXISTS `oeuvre_morceaux`;
CREATE TABLE IF NOT EXISTS `oeuvre_morceaux` (
  `id_oeuvre` int(11) NOT NULL,
  `id_morceaux` int(11) NOT NULL,
  PRIMARY KEY (`id_oeuvre`,`id_morceaux`),
  KEY `id_morceaux` (`id_morceaux`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `origine`
--

DROP TABLE IF EXISTS `origine`;
CREATE TABLE IF NOT EXISTS `origine` (
  `id_origine` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_origine`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `statut`
--

DROP TABLE IF EXISTS `statut`;
CREATE TABLE IF NOT EXISTS `statut` (
  `id_statut` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_statut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `support`
--

DROP TABLE IF EXISTS `support`;
CREATE TABLE IF NOT EXISTS `support` (
  `id_support` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  PRIMARY KEY (`id_support`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `type_artiste`
--

DROP TABLE IF EXISTS `type_artiste`;
CREATE TABLE IF NOT EXISTS `type_artiste` (
  `id_type_artiste` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_type_artiste`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `artiste_type_artiste`
--
ALTER TABLE `artiste_type_artiste`
  ADD CONSTRAINT `artiste_type_artiste_ibfk_1` FOREIGN KEY (`id_artiste`) REFERENCES `artiste` (`id_artiste`),
  ADD CONSTRAINT `artiste_type_artiste_ibfk_2` FOREIGN KEY (`id_type_artiste`) REFERENCES `type_artiste` (`id_type_artiste`);

--
-- Contraintes pour la table `oeuvre`
--
ALTER TABLE `oeuvre`
  ADD CONSTRAINT `oeuvre_ibfk_1` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id_categorie`),
  ADD CONSTRAINT `oeuvre_ibfk_2` FOREIGN KEY (`id_support`) REFERENCES `support` (`id_support`),
  ADD CONSTRAINT `oeuvre_ibfk_3` FOREIGN KEY (`id_origine`) REFERENCES `origine` (`id_origine`),
  ADD CONSTRAINT `oeuvre_ibfk_4` FOREIGN KEY (`id_statut`) REFERENCES `statut` (`id_statut`);

--
-- Contraintes pour la table `oeuvre_artiste`
--
ALTER TABLE `oeuvre_artiste`
  ADD CONSTRAINT `oeuvre_artiste_ibfk_1` FOREIGN KEY (`id_oeuvre`) REFERENCES `oeuvre` (`id_oeuvre`),
  ADD CONSTRAINT `oeuvre_artiste_ibfk_2` FOREIGN KEY (`id_artiste`) REFERENCES `artiste` (`id_artiste`);

--
-- Contraintes pour la table `oeuvre_critique`
--
ALTER TABLE `oeuvre_critique`
  ADD CONSTRAINT `oeuvre_critique_ibfk_1` FOREIGN KEY (`id_oeuvre`) REFERENCES `oeuvre` (`id_oeuvre`),
  ADD CONSTRAINT `oeuvre_critique_ibfk_2` FOREIGN KEY (`id_critique`) REFERENCES `critique` (`id_critique`);

--
-- Contraintes pour la table `oeuvre_genre`
--
ALTER TABLE `oeuvre_genre`
  ADD CONSTRAINT `oeuvre_genre_ibfk_1` FOREIGN KEY (`id_oeuvre`) REFERENCES `oeuvre` (`id_oeuvre`),
  ADD CONSTRAINT `oeuvre_genre_ibfk_2` FOREIGN KEY (`id_genre`) REFERENCES `genre` (`id_genre`);

--
-- Contraintes pour la table `oeuvre_langue`
--
ALTER TABLE `oeuvre_langue`
  ADD CONSTRAINT `oeuvre_langue_ibfk_1` FOREIGN KEY (`id_oeuvre`) REFERENCES `oeuvre` (`id_oeuvre`),
  ADD CONSTRAINT `oeuvre_langue_ibfk_2` FOREIGN KEY (`id_langue`) REFERENCES `langue` (`id_langue`);

--
-- Contraintes pour la table `oeuvre_morceaux`
--
ALTER TABLE `oeuvre_morceaux`
  ADD CONSTRAINT `oeuvre_morceaux_ibfk_1` FOREIGN KEY (`id_oeuvre`) REFERENCES `oeuvre` (`id_oeuvre`),
  ADD CONSTRAINT `oeuvre_morceaux_ibfk_2` FOREIGN KEY (`id_morceaux`) REFERENCES `morceaux` (`id_morceaux`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
