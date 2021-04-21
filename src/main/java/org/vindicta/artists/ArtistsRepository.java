package org.vindicta.artists;

import org.springframework.data.jpa.repository.JpaRepository;

interface ArtistsRepository extends JpaRepository<Artist, Long> {

}
