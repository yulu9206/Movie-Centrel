package cmpe275.dos.dao;

import cmpe275.dos.entity.MovieReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieReviewDao extends PagingAndSortingRepository<MovieReview, Integer> {

    @Query("select mr from MovieReview mr where mr.movie.movieId = :movieId")
    Page<MovieReview> findAllByMovieId(Pageable pageable, @Param("movieId") Integer movieId);

    @Query("select mr from MovieReview mr where mr.user.userId = :userId")
    Page<MovieReview> findAllByUserId(Pageable pageable, @Param("userId") Integer userId);

    @Query("select mr from MovieReview mr where mr.movie.movieId = :movieId and mr.user.userId = :userId ")
    Page<MovieReview> findAllByMovieIdAndUserId(Pageable pageable, @Param("movieId") Integer movieId, @Param("userId") Integer userId);

    @Query("select mr.movie, count(mr.reviewId), min(mr.stars), max(mr.stars) " +
            "from MovieReview mr group by mr.movie order by count(mr.reviewId) desc, mr.movie.releaseDate desc")
    Page<Object> findTop10MoviesByReviewNum (Pageable pageable);


    MovieReview findMovieReviewByReviewId(Integer reviewId);
}
